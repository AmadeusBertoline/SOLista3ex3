package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistroController {

	// Retorna o nome do SO
	private String Os() {

		return System.getProperty("os.name");

	}

	public void ExibeDistro() throws IOException {

		Process process = null;
		String osName = Os();

		try {

			if (osName.toLowerCase().contains("nix") || osName.toLowerCase().contains("nix")
					|| osName.toLowerCase().contains("mac")) {

				process = Runtime.getRuntime().exec("cat /etc/os-release");

				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String linha;

				while ((linha = reader.readLine()) != null) {

					linha = linha.trim();

					if (linha.toLowerCase().contains("name") || linha.toLowerCase().contains("version")) {

						System.out.println(linha);

					}

				}

				reader.close();
				process.waitFor();

			} else {

				System.out.println("O sistema operacional não é linux.");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
