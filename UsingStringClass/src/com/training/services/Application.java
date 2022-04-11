package com.training.services;

public class Application {

	public static void main(String[] args) {
		
		StringService service = new StringService();
		int key = 11;
		
		switch (key) {
		
		case 1:
			service.stringEquals("vishnu", "vishnu");
			break;
		case 2:
			service.stringObjectEquals();
			break;
		case 3:
			service.usingTrim("  vishnu  ");
			break;
		case 4:
			service.lengthOfString("vishnu");
			break;
		case 5:
			service.usingSubString("vishnu");
			break;
		case 6:
			service.usingChartAtAndIndexOf("vishnu@gmail");
			break;
		case 7:
			service.usingReplace("ram@abc.com", "hello guyss");
			break;
		case 8:
			service.usingConcat("I'm", " fineeee");
			break;
		case 9:
			service.usingCompareTo("gowse", "gowse");
			break;
		case 10:
			service.usingStringFormat("gowsick", 45.256);
			break;
		case 11:
			service.usingStringFormat(17);
			break;
		case 12:
			service.usingStringFormat(16, 16);
			break;
		case 13:
			service.usingStringFormat("ram","ram");
			break;
			
		default:
			break;
		}

	}

}
