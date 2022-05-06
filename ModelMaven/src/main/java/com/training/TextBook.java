package com.training;

public class TextBook {

		private String bookTitle;
		private int bookPrice;

		public String getBookTitle() {
			return bookTitle;
		}

		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}

		public TextBook(String bookTitle, int bookPrice) {
			super();
			this.bookTitle = bookTitle;
			this.bookPrice = bookPrice;
		}

		@Override
		public String toString() {
			return "TextBook [bookTitle=" + bookTitle + ", bookPrice=" + bookPrice + "]";
		}

		public int getBookPrice() {
			return bookPrice;
		}

		public void setBookPrice(int bookPrice) {
			this.bookPrice = bookPrice;
		}

		
		public String bookFilter(int price)
		{
			if (price < this.bookPrice )
			{
				this.bookTitle=bookTitle;
			}
			else
			{
				bookFilter(price + 400);
			}
			return bookTitle;
		}
		
	}

