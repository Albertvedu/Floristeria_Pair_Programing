package Floristeria.Gestio;

import static Floristeria.MainApp.opcion_Menu;
import Floristeria.dataValidation.DataValidation;
import Floristeria.View.*;
import java.util.Scanner;

public class Gestio_Floristeria {

	FloristeriaController controller = new FloristeriaController();
	DataValidation validator = new DataValidation();

	public Gestio_Floristeria() {

	}

	public void crear_Floristeria(Scanner sc) throws Exception {

		new View().menu_Crear_Floristeria();

		String nameFlorist = addName(sc);

		System.out.print("\t\t\tPor favor ingrese la dirección: ");
		String address = lectura_Datos(sc);
		boolean validateAddress = validator.verifyData(address);

		while (!validateAddress) {
			System.out.print("\t\t\tPor favor ingrese la dirección: ");
			address = lectura_Datos(sc);
			validateAddress = validator.verifyData(address);
		}

		System.out.print("\t\t\tPor favor ingrese el teléfono: ");
		String phone = lectura_Datos(sc);
		boolean validatePhone = validator.verifyPhone(phone);

		while (!validatePhone) {
			System.out.print("\t\t\tPor favor ingrese el teléfono: ");
			phone = lectura_Datos(sc);
			validatePhone = validator.verifyData(phone);
		}

		controller.createFlorist(nameFlorist, address, phone);

	}

	public void gestor_Floristeria(Scanner sc) throws Exception {
		while (true) {
			new View().Gestor_Floristeria();
			int opcion = opcion_Menu(sc, 6);

			switch (opcion) {
			case 1:
				// insertar_Arbol(sc);
				break;
			case 2:
				// insertar_Flor(sc);
				break;
			case 3:
				// insertar_Decoracion(sc);
				break;
			case 4:
				new View().ver_stock();
				break;
			case 5:
				System.exit(0);
			}
		}
	}

	void insertar_Arbol(Scanner sc) throws Exception {

		System.out.print("\n\t\t\t\t\t\t                            - ARBOL -  ");

		String treeName = addName(sc);

		System.out.print("\t\t\tPor favor ingrese el altura en centimetros: ");
		double treeHeight = 0;
		String hTree = lectura_Datos(sc);
		boolean validateHeight = validator.verifyDouble(hTree);

		while (!validateHeight) {
			System.out.print("\t\t\tPor favor ingrese la altura en centimetros: ");
			hTree = lectura_Datos(sc);
			validateHeight = validator.verifyDouble(hTree);
		}
		treeHeight = Double.parseDouble(hTree);

		double treePrice = addPrice(sc);

		controller.addTree(treeName, treePrice, treeHeight);

	}

	public String addName(Scanner sc) {

		System.out.print("\n\n\t\t\tPor favor ingrese el nombre: ");

		String name = lectura_Datos(sc);
		boolean validateName = validator.verifyName(name);

		while (!validateName) {
			System.out.print("\t\t\tPor favor ingrese el nombre: ");
			name = lectura_Datos(sc);
			validateName = validator.verifyName(name);
		}
		return name;
	}

	public double addPrice(Scanner sc) {

		double price = 0;
		System.out.print("\t\t\tPor favor ingrese el precio en  \u20AC : ");
		String pArticle = lectura_Datos(sc);
		boolean validatePrice = validator.verifyDouble(pArticle);

		while (!validatePrice) {
			System.out.print("\t\t\tPor favor ingrese el precio en \u20AC: ");
			pArticle = lectura_Datos(sc);
			validatePrice = validator.verifyDouble(pArticle);
		}
		return price = Double.parseDouble(pArticle);
	}

	private String lectura_Datos(Scanner sc) {
		String dato;
		dato = sc.nextLine();
		return dato;
	}
}
