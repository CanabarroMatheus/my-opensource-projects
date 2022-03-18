SET timezone = 'America/Sao_Paulo';

CREATE TYPE "expense_disc" AS ENUM (
  'EXPENSE',
  'BILL'
);

CREATE TYPE "expense_types" AS ENUM (
  'BASIC_NEEDS',
  'LEISURE',
  'GOODS',
  'GOAL',
  'UNEXPECTED',
  'STUDY'
);

CREATE TYPE "leisure_types" AS ENUM (
  'FOOD',
  'GAMES',
  'TRAVEL',
  'STREAMING',
  'SUBSCRIBE',
  'DONATION',
  'OTHERS'
);

CREATE TYPE "income_types" AS ENUM (
  'SALARY',
  'BONUS',
  'FREELANCE_WORK'
);

CREATE TYPE "goal_status" AS ENUM (
  'NOT_STARTED',
  'IN_PROGRESS',
  'FINISHED'
);

CREATE TABLE "users" (
  "id" varchar(255) PRIMARY KEY,
  "name" varchar(100) NOT NULL,
  "email" varchar(255) UNIQUE NOT NULL,
  "password" varchar(255) NOT NULL
);

CREATE TABLE "incomes" (
  "id" varchar(255) PRIMARY KEY,
  "title" varchar NOT NULL,
  "amount" decimal(12,2) NOT NULL,
  "type" income_types NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "updated_at" timestamp NOT NULL DEFAULT (now()),
  "user_id" varchar(255)
);

CREATE TABLE "expenses" (
  "expense" expense_disc NOT NULL,
  "id" varchar(255) PRIMARY KEY,
  "title" varchar NOT NULL,
  "price" decimal(12,2) NOT NULL,
  "type" expense_types NOT NULL,
  "leisure_type" leisure_types,
  "is_parted" boolean NOT NULL,
  "part_cost" decimal(12,2),
  "total_parts" integer,
  "target_date" date NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "updated_at" timestamp NOT NULL DEFAULT (now()),
  "goal_id" varchar(255),
  "user_id" varchar(255) NOT NULL
);

CREATE TABLE "user_preferences" (
  "id" varchar(255) PRIMARY KEY,
  "saving_percentage" decimal(3,2) NOT NULL DEFAULT (0),
  "user_id" varchar(255) NOT NULL
);

CREATE TABLE "goals" (
  "id" varchar(255) PRIMARY KEY,
  "title" varchar(255) NOT NULL,
  "total_cost" decimal(12,2) NOT NULL,
  "status" goal_status NOT NULL DEFAULT 'NOT_STARTED',
  "target_date" date NOT NULL,
  "created_at" timestamp NOT NULL DEFAULT (now()),
  "updated_at" timestamp NOT NULL DEFAULT (now()),
  "finished_at" timestamp,
  "user_id" varchar(255) NOT NULL
);

CREATE TABLE "balance" (
  "id" varchar(255) PRIMARY KEY,
  "availiable_balance" decimal(12,2) NOT NULL,
  "user_id" varchar(255) NOT NULL
);

CREATE TABLE "expense_leisures" (
  "id" varchar(255) PRIMARY KEY,
  "expense_id" varchar(255) NOT NULL,
  "leisure_id" varchar(255) NOT NULL
);

CREATE TABLE "monthly_report" (
  "id" varchar(255) PRIMARY KEY,
  "profit" decimal(12,2) NOT NULL,
  "loss" decimal(12,2) NOT NULL,
  "month" smallint NOT NULL,
  "balance_id" varchar(255) NOT NULL
);

CREATE TABLE "leisure" (
  "id" varchar(255) PRIMARY KEY,
  "type" leisure_types NOT NULL
);

ALTER TABLE "incomes" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "expenses" ADD FOREIGN KEY ("goal_id") REFERENCES "goals" ("id");

ALTER TABLE "expenses" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "user_preferences" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "goals" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "balance" ADD FOREIGN KEY ("user_id") REFERENCES "users" ("id");

ALTER TABLE "expense_leisures" ADD FOREIGN KEY ("expense_id") REFERENCES "expenses" ("id");

ALTER TABLE "expense_leisures" ADD FOREIGN KEY ("leisure_id") REFERENCES "leisure" ("id");

ALTER TABLE "monthly_report" ADD FOREIGN KEY ("balance_id") REFERENCES "balance" ("id");

COMMENT ON COLUMN "users"."id" IS 'UUID';

COMMENT ON COLUMN "incomes"."id" IS 'UUID';

COMMENT ON COLUMN "expenses"."id" IS 'UUID';

COMMENT ON COLUMN "user_preferences"."id" IS 'UUID';

COMMENT ON COLUMN "goals"."id" IS 'UUID';

COMMENT ON COLUMN "balance"."id" IS 'UUID';

COMMENT ON COLUMN "expense_leisures"."id" IS 'UUID';

COMMENT ON COLUMN "monthly_report"."id" IS 'UUID';

COMMENT ON COLUMN "leisure"."id" IS 'UUID';
