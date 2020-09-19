package model;
import java.util.ArrayList;

public class Budget{
	/**
	* Calculates the total price based on the prices of a specific store <br>
	* Pre: The list prices and quantities already have values. Same with materialsAmount and location <br>
	* Post: The total price based on the prices of a specific store <br>
	* @param materialsPrice Array used to calculate the total price materialsPriceHC != null
	* @param materialsQuantity The list with the required quantity of each material materialsQuantity != null
	* @param materialsAmount The number of elements needed 
	* @param location Location of the user location.equalsIgnoreCase("Norte" || "Centro" || "Sur")
	* @return result The total based on the prices of the store. Returns an integer
	*/
	public static int totalPrice(int[] materialsPrice, int[] materialsQuantity, int materialsAmount, String location){
		
		int result = 0;
		for (int i = 0; i < materialsAmount; i++){
			result += (materialsPrice[i] * materialsQuantity[i]);
		}
		
		if(result < 80000){
			if(location.equalsIgnoreCase("Norte") || location.equalsIgnoreCase("Sur")){
				result += 120000;
			}else if(location.equalsIgnoreCase("Centro")){
				result += 50000;
			}
		}else if(result < 300000){
			if(location.equalsIgnoreCase("Norte")){
				result += 28000;
			}else if(location.equalsIgnoreCase("Sur")){
				result += 55000;
			}
		}
		
		result += (1300000 + 2600000 + 980000);
		return result;
		
	}
	/**
	* Calculates the best price for each material out of the three available stores and gets a total price based on it <br>
	* Pre: The list of prices and quantities already have values. Same with materialsAmount <br>
	* Post: Calculates the cheapest price for each material out of the three available stores and gets a total price based on it <br>
	* @param materialsPriceHC Array used to calculate the cheapest price materialsPriceHC != null
	* @param materialsPriceFC Array used to calculate the cheapest price materialsPriceFC != null
	* @param materialsPriceFB Array used to calculate the cheapest price materialsPriceFB != null
	* @param materialsQuantity The list with the required quantity of each material materialsQuantity != null
	* @param materialsAmount The number of elements needed 
	* @return result The total based on the cheapest prices of the store.
	*/
	public static ArrayList<Integer> bestPrice(int[] materialsPriceHC, int[] materialsPriceFC, int[] materialsPriceFB, int[] materialsQuantity, int materialsAmount){
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < materialsAmount; i++){
			if (materialsPriceHC[i] < materialsPriceFC[i] && materialsPriceHC[i] < materialsPriceFB[i]){
				
				result.add((materialsPriceHC[i] * materialsQuantity[i]));
				
			}else if(materialsPriceFC[i] < materialsPriceHC[i] && materialsPriceFC[i] < materialsPriceFB[i]){
				
				result.add((materialsPriceFC[i] * materialsQuantity[i]));
				
			}else if(materialsPriceFB[i] < materialsPriceHC[i] && materialsPriceFB[i] < materialsPriceFC[i]){
				
				result.add((materialsPriceFB[i] * materialsQuantity[i]));
				
			}
		}
		
		return result;
		
	}
	/**
	* Calculates the store with the cheapest price for each material <br>
	* Pre: The list of prices already has values. Same with materialsAmount <br>
	* Post: Returns the store with the cheapest price for each material <br>
	* @param materialsPriceHC Array used to calculate the cheapest price materialsPriceHC != null
	* @param materialsPriceFC Array used to calculate the cheapest price materialsPriceFC != null
	* @param materialsPriceFB Array used to calculate the cheapest price materialsPriceFB != null
	* @param materialsAmount The number of elements needed 
	* @return result The total based on the cheapest prices of the store.
	*/
	public static ArrayList<String> bestStore(int[] materialsPriceHC, int[] materialsPriceFC, int[] materialsPriceFB, int materialsAmount){
		
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < materialsAmount; i++){
			if (materialsPriceHC[i] < materialsPriceFC[i] && materialsPriceHC[i] < materialsPriceFB[i]){
				
				result.add("Homecenter");
				
			}else if(materialsPriceFC[i] < materialsPriceHC[i] && materialsPriceFC[i] < materialsPriceFB[i]){
				
				result.add("ferreteria del centro");
				
			}else if(materialsPriceFB[i] < materialsPriceHC[i] && materialsPriceFB[i] < materialsPriceFC[i]){
				
				result.add("ferreteria del barrio");
				
			}
		}
		
		return result;
		
	}
	/**
	* Lists materials based on their type <br>
	* Pre: The list of names and types already have values. Same with materialsAmount. <br>
	* Post: Returns a list of materials based on their type/use <br>
	* @param materialsName Array used to store the name of the material in the list materialsName != null
	* @param materialsType Array used to get the material's type materialsName != null
	* @param type Value used to check if the material's type corresponds to one of the three categories type.equalsIgnoreCase("Obra blanca" || "Obra negra" || "Pintura")
	* @param materialsAmount The number of elements needed 
	* @return result An array of materials based of their type.
	*/
	public static ArrayList<String> materialsType(String[] materialsName, String[] materialsType, String type, int materialsAmount){
		
		ArrayList<String> result = new ArrayList<String>();
		
		if(type.equalsIgnoreCase("Obra negra")){
			for(int i = 0; i < materialsAmount; i++){
				if(materialsType[i].equalsIgnoreCase("Obra negra")){
					result.add(materialsName[i]);
				}
			}
		}else if(type.equalsIgnoreCase("Obra blanca")){
			for(int i = 0; i < materialsAmount; i++){
				if(materialsType[i].equalsIgnoreCase("Obra blanca")){
					result.add(materialsName[i]);
				}
			}
		}else if(type.equalsIgnoreCase("Pintura")){
			for(int i = 0; i < materialsAmount; i++){
				if(materialsType[i].equalsIgnoreCase("Pintura")){
					result.add(materialsName[i]);
				}
			}
		}
		
		return result;
		
	}
	
}