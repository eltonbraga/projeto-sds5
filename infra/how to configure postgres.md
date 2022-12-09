1 - Run the docker compose (docker compose up -d)
2 - Log in PG Admin
    user: example@example.com.br
    password: docker compose password (123456789)
3 - Add a new server
    - Right click in server -> register -> server
    - Tab general
        - Tip a server name
    - Tab Connection
        - Postgres hostname in docker compose file (teste-postgres-compose)
        - Default port (5432) - not 15432 (because pgadmin is in the same docker network)
        - username: postgres default (postgres)
        - password: the same in docker compose file (123456789)
    - Click in save / create
4 - Add new database
5 - Is ready to use