package csc131.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;



class GiftCardTest {

	@Test
	public void getIssuingStore() 
	{
		double balance;
		GiftCard card;
		int issuingStore;
	
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	
	public void getBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String example = "Remaining Balance: " + String.format("%6.2f", 75.00);
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct(25.00)", example,  card.deduct(25.00));
		
	}
	
	@Test
	public void deduct_AmountDue()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String example = "Amount Due: " + String.format("%6.2f",
                Math.abs(900.00));;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct(1000.00)", example,  card.deduct(1000.00));
		
		
	}
	
	@Test
	public void deduct_InvalidTransaction()
	{
		double balance;
		GiftCard card;
		int issuingStore;
		String example = "Invalid Transaction";
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct(-1000.00)", example,  card.deduct(-1000.00));
		
		
	}
	
	
	@Test
	public void giftCard_IllegalArgumentException()
	{
		assertThrows(IllegalArgumentException.class,() -> {new GiftCard(1,-100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_Low()
	{
		assertThrows(IllegalArgumentException.class,() -> {new GiftCard(-5, 100.00);});
	}
	
	@Test
	public void constructor_IncorrectID_High()
	{
		assertThrows(IllegalArgumentException.class,() -> {new GiftCard(10000, 100.00);});
	}

}
