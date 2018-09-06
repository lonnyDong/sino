package com.sino.pattern.event;

public class TestDemo {

	public static void main(String[] args) {

		ClickListener clickListener = new ClickListener();
		Page page = new Page();
		page.addClickListener(clickListener);
		ClickEvent clickEvent = new ClickEvent(page, 1);
		page.trigger(clickEvent);

	}


}
