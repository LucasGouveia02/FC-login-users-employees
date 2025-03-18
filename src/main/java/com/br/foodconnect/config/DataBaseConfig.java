package com.br.foodconnect.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class DataBaseConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        Dotenv dotenv = Dotenv.configure()
                .directory("env/local")
                .filename("env")
                .load();

        String usernamePath = dotenv.get("DB_USERNAME_PATH");
        String passwordPath = dotenv.get("DB_PASSWORD_PATH");
        String dbDriverName = dotenv.get("DB_DRIVER_NAME");
        String dbUrl = dotenv.get("DB_URL");

        String username = new String(Files.readAllBytes(Paths.get(usernamePath)));
        String password = new String(Files.readAllBytes(Paths.get(passwordPath)));

        HikariConfig config = new HikariConfig();
        config.setDriverClassName(dbDriverName);
        config.setJdbcUrl(dbUrl);
        config.setUsername(username.trim());
        config.setPassword(password.trim());

        return new HikariDataSource(config);
    }
}