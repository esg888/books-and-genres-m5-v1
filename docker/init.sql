create schema if not exists app_schema;
-- //CREATE DATABASE IF NOT EXISTS shelf;
DO $$
BEGIN
BEGIN
        CREATE DATABASE shelf;
EXCEPTION
        WHEN duplicate_database THEN RAISE NOTICE 'Database already exists.';
END;
END $$;