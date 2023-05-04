package br.com.doctordevs.connecthealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;;

@SpringBootApplication
public class ConnecthealthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnecthealthApplication.class, args);

		String url = "jdbc:mysql://root:UuEK82PrwXnyIStQCU8T@containers-us-west-184.railway.app:8053/railway";
		String usuario = "root";
		String senha = "UuEK82PrwXnyIStQCU8T";

		DataSource dataSource = new DriverManagerDataSource(url, usuario, senha);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		try {
			jdbcTemplate.queryForObject("SELECT 1", Integer.class);
			System.out.println("Conexão com o banco de dados bem sucedida!");
		} catch (Exception e) {
			System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		}
			}

}
