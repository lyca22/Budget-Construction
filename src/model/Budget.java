package model;
import java.util.ArrayList;

public class Budget{
	
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