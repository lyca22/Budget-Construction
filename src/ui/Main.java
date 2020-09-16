package ui;
import java.util.Scanner;
import java.util.ArrayList;
import model.*;

public class Main{
	
	public static int setMaterialsAmount(Scanner sc){
		
		System.out.println("Ingrese la cantidad de materiales que va a usar:");
		int materialsAmount = sc.nextInt();
		sc.nextLine();
		return materialsAmount;
	}
	
	public static String[] setMaterialsName(String[] materialsName, int i, Scanner sc){
		
		System.out.println("Ingrese el nombre del material numero " + (i+1) + ":");
		materialsName[i] = sc.nextLine();
		return materialsName;
		
	}
	
	public static int[] setPrice(String store, int[] materialsPrice, int i, Scanner sc){
		
		if (store.equalsIgnoreCase("Homecenter")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en Homecenter:");
			materialsPrice[i] = sc.nextInt();
			
		}else if (store.equalsIgnoreCase("FerreteriaCentro")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en la ferreteria del centro:");
			materialsPrice[i] = sc.nextInt();
			
		}else if (store.equalsIgnoreCase("FerreteriaBarrio")){
			
			System.out.println("Ingrese el precio del material " + (i+1) + " en la ferreteria del barrio:");
			materialsPrice[i] = sc.nextInt();
			
		}
		
		return materialsPrice;
		
	}
	
	public static int[] setMaterialsQuantity(int[] materialsQuantity, int i, Scanner sc){
		
		System.out.println("Ingrese la cantidad del material numero " + (i+1) + ":");
		materialsQuantity[i] = sc.nextInt();
		return materialsQuantity;
		
	}
	
	public static String[] setMaterialsType(String[] materialsType, int i, Scanner sc){
		
		System.out.println("Ingrese el tipo del material numero " + (i+1) + ":");
		materialsType[i] = sc.nextLine();
		return materialsType;
		
	}
	
	public static String setLocation(Scanner sc){
		
		System.out.println("Ingrese la ubicacion inmueble:");
		String location = sc.nextLine();
		return location;
		
	}
	
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