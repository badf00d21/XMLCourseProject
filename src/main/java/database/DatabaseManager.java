package database;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Local;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@Local(IDatabaseManager.class)
public class DatabaseManager implements IDatabaseManager {

    private DatabaseClient client;
    private DatabaseClient schemaClient;

    @PostConstruct
    public void init() {
        client = DatabaseClientFactory.newClient(DatabaseConfig.host,
                DatabaseConfig.port,
                DatabaseConfig.user,
                DatabaseConfig.password,
                DatabaseConfig.authType);

        schemaClient = DatabaseClientFactory.newClient(DatabaseConfig.host,
                DatabaseConfig.port,
                "Schemas",
                DatabaseConfig.user,
                DatabaseConfig.password,
                DatabaseConfig.authType);
    }

    @PreDestroy
    public void remove() {
        client.release();
        schemaClient.release();
    }

    @Override
    public DatabaseClient getDatabaseClient() {
        return client;
    }

}
