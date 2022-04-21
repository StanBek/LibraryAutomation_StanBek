package com.libraryApp.testbase;


import com.libraryApp.pages.DashBoardPage;
import com.libraryApp.pages.LoginPage;

/**
 * This an initializer class which will initialize all pages classes. Once pages
 * class created, create an object of it here inside the constructor
 */
public class PagesInitializer {

	protected static LoginPage loginPage;
	protected static DashBoardPage dashBoardPage;

static {
		loginPage = new LoginPage();
		dashBoardPage=new DashBoardPage();
	}



}
