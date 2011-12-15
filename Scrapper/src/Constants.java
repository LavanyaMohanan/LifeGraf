import java.util.HashMap;


public class Constants {
	
	static HashMap<String,Integer> Attributes=new HashMap<String,Integer>();

	public Constants() {
		
		
		addAttribute("Meal, Inexpensive Restaurant");
		addAttribute("Meal for 2, Mid-range Restaurant, Three-course");
		addAttribute("Combo Meal at McDonalds or Similar");
		addAttribute("Domestic Beer (0.5 liter draught)");
		addAttribute("Imported Beer (0.33 liter bottle)");
		addAttribute("Cappuccino (regular)");
		addAttribute("Coke/Pepsi (0.33 liter bottle)");
		addAttribute("Water (0.33 liter bottle)");
		addAttribute("Milk (regular), 1 liter");
		addAttribute("Loaf of Fresh White Bread (500g)");
		addAttribute("Eggs (12)");
		addAttribute("Fresh Cheese (1kg)");
		addAttribute("Chicken Breasts (Boneless, Skinless), (1kg)");
		addAttribute("Apples (1kg)");
		addAttribute("Oranges (1kg)");
		addAttribute("Potato (1kg)");
		addAttribute("Lettuce (1 head)");
		addAttribute("Water (1.5 liter bottle)");
		addAttribute("Bottle of Wine (Mid-Range)");
		addAttribute("Domestic Beer (0.5 liter bottle)");
		addAttribute("Imported Beer (0.33 liter bottle)");
		addAttribute("Pack of Cigarettes (Marlboro)");
		addAttribute("One-way Ticket (local transport)");
		addAttribute("Monthly Pass");
		addAttribute("Taxi Start (Normal Tariff)");
		addAttribute("Taxi 1km (Normal Tariff)");
		addAttribute("Taxi 1hour Waiting (Normal Tariff)");
		addAttribute("Gasoline (1 liter)");
		addAttribute("Volkswagen Golf 1.4 90 KW Trendline (Or Equivalent New Car)");
		addAttribute("Basic (Electricity, Gas, Water, Garbage)");
		addAttribute("1 min. of Prepaid Mobile Tariff (no discounts or plans)");
		addAttribute("Internet (6 Mbps, Flat Rate, Cable/ADSL)");
		addAttribute("Fitness Club, Monthly Fee for 1 Adult");
		addAttribute("Tennis Court Rent (1 Hour on Weekend)");
		addAttribute("Cinema, International Release, 1 Seat");
		addAttribute("1 Pair of Levis 501");
		addAttribute("1 Summer Dress in a Chain Store (Zara, H&M, ...)");
		addAttribute("1 Pair of Nike Shoes");
		addAttribute("1 Pair of Men Leather Shoes");
		addAttribute("Apartment (1 bedroom) in City Centre");
		addAttribute("Apartment (1 bedroom) Outside of Centre");
		addAttribute("Apartment (3 bedrooms) in City Centre");
		addAttribute("Apartment (3 bedrooms) Outside of Centre");
		addAttribute("Price per Square Meter to Buy Apartment in City Centre");
		addAttribute("Price per Square Meter to Buy Apartment Outside of Centre");
		addAttribute("Median Monthly Disposable Salary (After Tax)");
		addAttribute("Mortgage Interest Rate in Percentanges (%), Yearly");	}
	
	private void addAttribute(String attributeString){
		int size = Attributes.size();
		Attributes.put(attributeString, size);
	}
}
