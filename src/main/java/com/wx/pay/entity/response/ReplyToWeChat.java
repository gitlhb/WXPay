package com.wx.pay.entity.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回复微信的应答消息
 * 
 * @author liuhongbing
 *
 */
@XmlRootElement(name = "xml")
public class ReplyToWeChat implements Serializable {

	private static final long serialVersionUID = 1L;

	private String return_code;

	private String return_msg;

	public String getReturn_code() {
		return return_code;
	}

	@XmlElement(name = "return_code")
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	@XmlElement(name = "return_msg")
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	@Override
	public String toString() {
		return "ReplyToWeChat [return_code=" + return_code + ", return_msg=" + return_msg + "]";
	}

}
