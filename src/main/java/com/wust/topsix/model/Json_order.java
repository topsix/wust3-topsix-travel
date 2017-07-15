package com.wust.topsix.model;

import java.util.ArrayList;

import com.wust.topsix.beans.Order;

public class Json_order<T> {
	int draw;
	int recordsTotal;
	int recordFiltered;
	ArrayList<Order> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordFiltered() {
		return recordFiltered;
	}

	public void setRecordFiltered(int recordFiltered) {
		this.recordFiltered = recordFiltered;
	}

	public ArrayList<Order> getData() {
		return data;
	}

	public void setData(ArrayList<Order> data) {
		this.data = data;
	}

}