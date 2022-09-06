# Agenda_JPA_Web1


Esquema Hibernate / Maven
1. Criar o Banco de Dados na aba Serviços (se não estiver criado);
2. Criar novo projeto Maven;
3. Incluir as dependências:
 mysql-connector-java
 hibernate-core
 hibernate-entitymanager
4. Criar uma Unidade de Persistência e adaptar do JPA para o Hibernate;
 - Retirar a sessão "provider"
 - Substituir a sessão "properties" pelo esquema no final desse arquivo
 - Retirar das dependências qualquer menção a "org.eclipse.persistence" 
5. Criar pacote "model", e a(s) classe(s) de domínio com as devidas "annotations";
6. Criar pacote "model.dao" e arquivo java "ConnFactory";
7. Criar pacote "view" e implementar a classe principal.
Esquema da sessão properties:
 <properties>
 <property name="hibernate.connection.url" value 
="jdbc:mysql://localhost:3306/agenda"/>
 <property name="hibernate.dialect" value = 
"org.hibernate.dialect.MySQL8Dialect"/>
 <property name="hibernate.connection.driver_class" value = 
"com.mysql.jdbc.Driver"/>
 <property name="hibernate.connection.username" value="root"/>
 <property name="hibernate.connection.password" value =""/>
 <property name="hibernate.hbm2ddl.auto" value = "update"/>
 <property name="hibernate.show_sql" value = "true"/>
 </properties>
