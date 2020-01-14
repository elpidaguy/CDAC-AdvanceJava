package com.app.pojos;

import java.time.LocalDate;
import javax.persistence.*;

@Embeddable
public class Card {
	private String cardNo;
	private LocalDate expDate;
	private int cvv;
	private CardType cType;
	
	public Card() {
		System.out.println("in card constr");
	}
	public Card(String cardNo, LocalDate expDate, int cvv, CardType cType) {
		super();
		this.cardNo = cardNo;
		this.expDate = expDate;
		this.cvv = cvv;
		this.cType = cType;
	}
	@Column(name="card_no",length=20)
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	@Column(name="exp_date")
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="card_type",length=10)
	public CardType getcType() {
		return cType;
	}
	public void setcType(CardType cType) {
		this.cType = cType;
	}
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", expDate=" + expDate + ", cvv=" + cvv + ", cType=" + cType + "]";
	}
	
	

}
