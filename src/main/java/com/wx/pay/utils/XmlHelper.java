package com.wx.pay.utils;

import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.StringConverter;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

/**
 * XML������
 * 
 * @author liuhongbing
 *
 */
public final class XmlHelper extends StringConverter {

	private static final ConcurrentHashMap<Class<?>, XStream> CLASS_2_XSTREAM_INSTANCE = new ConcurrentHashMap<Class<?>, XStream>();
	public static boolean hasCData = Boolean.TRUE;
	public static boolean HasDeclaration = Boolean.TRUE;
	public static String Encoding = "UTF-8";
	public static final String XML_TAG = "<?xml version='1.0' encoding='UTF-8'?>";
	private static XStream xstream = null;

	public static XStream getInstance() {
		xstream = new XStream(new DomDriver("utf-8") {
			@Override
			public HierarchicalStreamWriter createWriter(Writer out) {
				return new PrettyPrintWriter(out, getNameCoder()) {
					protected String PREFIX_CDATA = "<![CDATA[";
					protected String SUFFIX_CDATA = "]]>";

					@Override
					protected void writeText(QuickWriter writer, String text) {
						if (text.startsWith(this.PREFIX_CDATA) && text.endsWith(this.SUFFIX_CDATA)) {
							writer.write(text);
						} else {
							super.writeText(writer, text);
						}
					}

					@Override
					public String encodeNode(String name) {
						return name;
					}
				};
			}
		});
		xstream.ignoreUnknownElements();
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.addPermission(NullPermission.NULL);
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES);
		return xstream;
	}

	/**
	 * xmlתjava����
	 * 
	 * @param xml
	 *            xml��
	 * @param clazz
	 *            ������ֽ���
	 * @return java����
	 */
	@SuppressWarnings("unchecked")
	public static <T> T toBean(String xml, Class<T> clazz) {
		if (!CLASS_2_XSTREAM_INSTANCE.containsKey(clazz)) {
			registerClass(clazz);
		}
		T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(xml);
		return object;
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromXml(InputStream is, Class<T> clazz) {
		if (!CLASS_2_XSTREAM_INSTANCE.containsKey(clazz)) {
			registerClass(clazz);
		}
		T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(is);
		return object;
	}

	/**
	 * java����תxml
	 * 
	 * @param object
	 *            java����
	 * @param clazz
	 *            java������ֽ���
	 * @return xml
	 */
	public static <T> String toXml(T object, Class<T> clazz) {
		if (!CLASS_2_XSTREAM_INSTANCE.containsKey(clazz)) {
			registerClass(clazz);
		}
		return CLASS_2_XSTREAM_INSTANCE.get(clazz).toXML(object);
	}

	/**
	 * ע����չ��Ϣ�Ľ�����
	 *
	 * @param clz
	 *            ����
	 * @param xStream
	 *            xml������
	 */
	private static void register(Class<?> clz, XStream xStream) {
		CLASS_2_XSTREAM_INSTANCE.put(clz, xStream);
	}

	/**
	 * ���Զ�ע����༰������
	 *
	 * @param clz
	 *            Ҫע�����
	 */
	private static void registerClass(Class<?> clz) {
		XStream xstream = XmlHelper.getInstance();
		xstream.processAnnotations(clz);
		xstream.processAnnotations(getInnerClasses(clz));
		register(clz, xstream);
	}

	private static Class<?>[] getInnerClasses(Class<?> clz) {
		Class<?>[] innerClasses = clz.getClasses();
		if (innerClasses == null) {
			return null;
		}

		List<Class<?>> result = new ArrayList<Class<?>>();
		result.addAll(Arrays.asList(innerClasses));
		for (Class<?> inner : innerClasses) {
			Class<?>[] innerClz = getInnerClasses(inner);
			if (innerClz == null) {
				continue;
			}
			result.addAll(Arrays.asList(innerClz));
		}
		return result.toArray(new Class<?>[0]);
	}

	/**
	 * String ת org.dom4j.Document
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	public static Document strToDocument(String xml) throws DocumentException {
		return DocumentHelper.parseText(xml);
	}

	/**
	 * org.dom4j.Document ת com.alibaba.fastjson.JSONObject
	 * 
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	public static JSONObject documentToJSONObject(String xml) throws DocumentException {
		return elementToJSONObject(strToDocument(xml).getRootElement());
	}

	/**
	 * org.dom4j.Element ת com.alibaba.fastjson.JSONObject
	 * 
	 * @param node
	 * @return
	 */
	public static JSONObject elementToJSONObject(Element node) {
		JSONObject result = new JSONObject();
		// ��ǰ�ڵ�����ơ��ı����ݺ�����
		List<Attribute> listAttr = node.attributes();// ��ǰ�ڵ���������Ե�list
		for (Attribute attr : listAttr) {// ������ǰ�ڵ����������
			result.put(attr.getName(), attr.getValue());
		}
		// �ݹ������ǰ�ڵ����е��ӽڵ�
		List<Element> listElement = node.elements();// ����һ���ӽڵ��list
		if (!listElement.isEmpty()) {
			for (Element e : listElement) {// ��������һ���ӽڵ�
				if (e.attributes().isEmpty() && e.elements().isEmpty()) // �ж�һ���ڵ��Ƿ������Ժ��ӽڵ�
					result.put(e.getName(), e.getTextTrim());// �]���򽫵�ǰ�ڵ���Ϊ�ϼ��ڵ�����ԶԴ�
				else {
					if (!result.containsKey(e.getName())) // �жϸ��ڵ��Ƿ���ڸ�һ���ڵ����Ƶ�����
						result.put(e.getName(), new JSONArray());// û���򴴽�
					((JSONArray) result.get(e.getName())).add(elementToJSONObject(e));// ����һ���ڵ����ýڵ����Ƶ����Զ�Ӧ��ֵ��
				}
			}
		}
		return result;
	}

	@Override
	public String toString(Object obj) {
		if (XmlHelper.hasCData) {
			return "<![CDATA[" + super.toString(obj) + "]]>";
		} else {
			return super.toString(obj);
		}
	}

}
