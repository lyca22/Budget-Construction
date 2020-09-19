package ui;
import java.util.Scanner;
import java.util.ArrayList;
import model.*;

public class Main{
	/**
	* Allows the user to set the number of elements needed for the construction <br>
	* Pre: <br>
	* Post: The number of elements has been stored <br>
	* @param sc Scanner used to ask the user for the information sc != null
	* @return materialsAmount The number of elements. Returns an integer
	*/
	public static int setMaterialsAmount(Scanner sc){
		
		System.out.println("Ingrese la cantidad de materiales que va a usar:");
		int materialsAmount = sc.nextInt();
		sc.nextLine();
		return materialsAmount;
	}
	/**
	* Allows the user to set the name of a specific material <br>
	* Pre: The list of materials has been initialized <br>
	* Post: The name of each material has been stored <br>
	* @param materialsName Array used to store the name of each material materialsName != null
	* @param i Value used to access an specific index of the array i != null
	* @param sc Scanner used to ask the user for the information sc != null
	* @return materialsName The names of the materials.
	*/
	public static String[] setMaterialsName(String[] materialsName, int i, Scanner sc){
		
		System.out.println("Ingrese el nombre del material numero " + (i+1) + ":");
		materialsName[i] = sc.nextLine();
		return materialsName;
		
	}
	/**
	* Allows the user to set the price of a specific material <br>
	* Pre: The list of prices for the materials has been initialized <br>
	* Post: The price of the material in the selected store has been stored <br>
	* @param store Used to select the store
	* @param materialsPrice Array used to store the price of the material materialsPrice != null
	* @param i Value used to access an specific index of the array i != null
	* @param sc Scanner used to ask the user for the information sc != null
	* @return materialsPrice The list with the added price for that material
	*/
	public static int[] setPrice(String store, int[] materialsPrice, int i, Scanner sc){
		
		if (store.equalsIgnoreCase("Homecenter")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en Homecenter:");
			
		}else if (store.equalsIgnoreCase("FerreteriaCentro")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en la ferreteria del centro:");
			
		}else if (store.equalsIgnoreCase("FerreteriaBarrio")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en la ferreteria del barrio:");
			
		}
		
		materialsPrice[i] = sc.nextInt();
		return materialsPrice;
		
	}
	/**
	* Allows the user to set the quantity of a specific material <br>
	* Pre: The list of quantities for the materials has been initialized <br>
	* Post: The needed quantity of the material has been stored <br>
	* @param materialsQuantity Array used to store the needed quantity of the material materialsQuantity != null
	* @param i Value used to access an specific index of the array i != null
	* @param sc Scanner used to ask the user for the information sc != null
	* @return materialsQuantity The list with the added quantity for that material
	*/
	public static int[] setMaterialsQuantity(int[] materialsQuantity, int i, Scanner sc){
		
		System.out.println("Ingrese la cantidad del material numero " + (i+1) + ":");
		materialsQuantity[i] = sc.nextInt();
		return materialsQuantity;
		
	}
	/**
	* Allows the user to set the type of a specific material <br>
	* Pre: The list of types for the materials has been initialized <br>
	* Post: The type of the material has been stored <br>
	* @param materialsType Array used to store the type of the material materialsType != null
	* @param i Value used to access an specific index of the array i != null
	* @param sc Scanner used to ask the user for the information sc != null
	* @return materialsType The list with the added type for that material
	*/
	public static String[] setMaterialsType(String[] materialsType, int i, Scanner sc){
		
		System.out.println("Ingrese el tipo del material numero " + (i+1) + ":");
		materialsType[i] = sc.nextLine();
		return materialsType;
		
	}
	/**
	* Allows the user to set their location <br>
	* Pre: <br>
	* Post: The user's location has been stored <br>
	* @param sc Scanner used to ask the user for the information sc != null
	* @return location The location of the user. Returns a String location.equalsIgnoreCase("Norte" || "Centro" || "Sur")
	*/
	public static String setLocation(Scanner sc){
		
		System.out.println("Ingrese la ubicacion inmueble:");
		String location = sc.nextLine();
		return location;
		
	}
	/**
	* Shows the cheapest price for each material and calculates the total based on them <br>
	* Pre: The list of names, prices and quantities already have values. Same with materialsAmount and location <br>
	* Post: The cheapest price for each material and the total based on them <br>
	* @param materialsName Array used to print the name of each material materialsName != null
	* @param materialsPriceHC Array used to calculate the cheapest price materialsPriceHC != null
	* @param materialsPriceFC Array used to calculate the cheapest price materialsPriceFC != null
	* @param materialsPriceFB Array used to calculate the cheapest price materialsPriceFB != null
	* @param materialsQuantity The list with the required quantity of each material materialsQuantity != null
	* @param materialsAmount The number of elements needed 
	* @param location Location of the user location.equalsIgnoreCase("Norte" || "Centro" || "Sur")
	* @return result The total based on the cheapest prices. Returns an integer
	*/
	public static int showBestPrices(String[] materialsName, int[] materialsPriceHC, int[] materialsPriceFC, int[] materialsPriceFB, int[] materialsQuantity, int materialsAmount, String location){
		
		ArrayList<Integer> bestPrice = Budget.bestPrice(materialsPriceHC, materialsPriceFC, materialsPriceFB, materialsQuantity, materialsAmount);
		ArrayList<String> bestStore = Budget.bestStore(materialsPriceHC, materialsPriceFC, materialsPriceFB, materialsAmount);
		
		int result = 0;
		
		System.out.println("Materiales con los mejores precios:");
		for (int i = 0; i < materialsAmount; i++){
			System.out.println(materialsName[i] + ": " + bestPrice.get(i) + " en " + bestStore.get(i));
			result += bestPrice.get(i);
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
	* Shows materials based on their type <br>
	* Pre: The list of names and types already have values. Same with materialsAmount. <br>
	* Post: Shows the user a list of materials based on their type/use <br>
	* @param materialsName Array used in the materialsType method != null
	* @param materialsType Array used to get the material's type materialsName != null
	* @param type Value used in the materialsType method type.equalsIgnoreCase("Obra blanca" || "Obra negra" || "Pintura")
	* @param materialsAmount The number of elements needed 
	*/
	public static void showMaterialsType (String[] materialsName, String[] materialsType, String type, int materialsAmount){
		
		ArrayList<String> result = Budget.materialsType(materialsName, materialsType, type, materialsAmount);
		
		System.out.println("Materiales de " + type + ":");
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
		
	}
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int materialsAmount = setMaterialsAmount(sc);
		String[] materialsName = new String[materialsAmount];
		int[] materialsPriceHC = new int[materialsAmount];
		int[] materialsPriceFC = new int[materialsAmount];
		int[] materialsPriceFB = new int[materialsAmount];
		int[] materialsQuantity = new int[materialsAmount];
		String[] materialsType = new String[materialsAmount];
		
		for (int i = 0; i < materialsAmount; i++){
			setMaterialsName(materialsName, i, sc);
			setPrice("Homecenter", materialsPriceHC, i, sc);
			setPrice("FerreteriaCentro", materialsPriceFC, i, sc);
			setPrice("FerreteriaBarrio", materialsPriceFB, i, sc);
			setMaterialsQuantity(materialsQuantity, i, sc);
			sc.nextLine();
			setMaterialsType(materialsType, i, sc);
		}
		
		String location = setLocation(sc);
		System.out.println();
		
		System.out.println("El precio total de Homecenter es: " + Budget.totalPrice(materialsPriceHC, materialsQuantity, materialsAmount, location));
		System.out.println("El precio total de la ferreteria del centro es: " + Budget.totalPrice(materialsPriceFC, materialsQuantity, materialsAmount, location));
		System.out.println("El precio total de la ferreteria del barrio es: " + Budget.totalPrice(materialsPriceFB, materialsQuantity, materialsAmount, location));
		System.out.println();
		
		int bestTotal = showBestPrices(materialsName, materialsPriceHC, materialsPriceFC, materialsPriceFB, materialsQuantity, materialsAmount, location);
		System.out.println();
		
		System.out.println("Total a pagar por mejor precio en cada tienda: " + bestTotal);
		System.out.println();
		
		showMaterialsType(materialsName, materialsType, "Obra negra", materialsAmount);
		showMaterialsType(materialsName, materialsType, "Obra blanca", materialsAmount);
		showMaterialsType(materialsName, materialsType, "Pintura", materialsAmount);
		
	}
	
}