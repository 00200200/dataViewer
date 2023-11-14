module client {
    exports pl.dataViewer.client;
    requires com.google.gson;
    requires java.net.http;
    requires mysql.connector.java;
    requires java.sql;
    opens pl.dataViewer.client.db to mysql.connector.java;
    opens pl.dataViewer.client to com.google.gson;
}