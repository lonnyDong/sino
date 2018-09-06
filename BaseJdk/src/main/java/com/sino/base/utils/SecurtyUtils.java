package com.sino.base.utils;

/**
 * 数据脱敏
 * @author lonny
 *
 */
public class SecurtyUtils {
	
	/**
	 * 邮箱脱敏
	 * @param email
	 * @return
	 */
	public static final String hideEmail(String email)
	  {
	    StringBuffer rs = new StringBuffer();
	    int index = email.lastIndexOf(64);
	    if (index > 0) {
	      int p = (index < 5) ? index / 2 : 3;
	      rs.append(email.substring(0, p));
	      appendSec(rs, index - p);
	      rs.append(email.substring(index));
	    }
	    return ((rs.length() == 0) ? email : rs.toString());
	  }

	  public static final String hideMobileno(String mobileno) {
	    StringBuffer rs = new StringBuffer();
	    int len = mobileno.length();
	    if (len < 11) {
	      int p = len / 3;
	      int m = len - p - p;
	      rs.append(mobileno.substring(0, p));
	      appendSec(rs, m);
	      rs.append(mobileno.substring(len - p, len));
	    }
	    else {
	      rs.append(mobileno.substring(0, 3));
	      appendSec(rs, len - 7);
	      rs.append(mobileno.substring(len - 4, len));
	    }
	    return ((rs.length() == 0) ? mobileno : rs.toString());
	  }

	  public static final String hideCardno(String cardno) {
	    StringBuffer rs = new StringBuffer();
	    int len = cardno.length();
	    if (len == 18) {
	      rs.append(cardno.substring(0, 4));
	      appendSec(rs, 10);
	      rs.append(cardno.substring(len - 4, len));
	    }
	    else {
	      int p = len / 3;
	      int m = len - p - p;
	      rs.append(cardno.substring(0, p));
	      appendSec(rs, m);
	      rs.append(cardno.substring(len - p, len));
	    }
	    return ((rs.length() == 0) ? cardno : rs.toString());
	  }

	  public static final String hideOthers(String value) {
	    StringBuffer rs = new StringBuffer();
	    int len = value.length();
	    if (len > 3) {
	      rs.append(value.substring(0, 3));
	      appendSec(rs, len - 7);
	      rs.append(value.substring(len - 4, len));
	    }
	    else if (len > 1) {
	      appendSec(rs, len - 1);
	      rs.append(value.substring(len - 1, len));
	    }
	    return ((rs.length() == 0) ? value : rs.toString());
	  }
	  
	  private static StringBuffer appendSec(StringBuffer buf, int len) {
		    int i = len;
		    while (i > 0) {
		      buf.append("*");
		      --i;
		    }

		    return buf;
		  }
}
