package view;

import controller.*;

public class Main {

	public static void main(String[] args) {

		DistroController distro = new DistroController();

		try {

			distro.ExibeDistro();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
