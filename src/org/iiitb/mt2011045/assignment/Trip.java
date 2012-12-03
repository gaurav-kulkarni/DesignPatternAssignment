package org.iiitb.mt2011045.assignment;

public class Trip {
	private String name;
	private String from;
	private String to;
	private String via;
	private String agent;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Trip [name=" + name + ", from=" + from + ", to=" + to
				+ ", via=" + via + ", agent=" + agent + ", date=" + date + "]";
	}
	
	

}
