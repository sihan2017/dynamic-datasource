CREATE TABLE "public"."common" (
  "id" int2 NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "code" varchar(255) COLLATE "pg_catalog"."default",
  CONSTRAINT "common_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."common" 
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."common"."id" IS '主键id';

COMMENT ON COLUMN "public"."common"."name" IS '名称';

COMMENT ON COLUMN "public"."common"."code" IS '编码';

COMMENT ON TABLE "public"."common" IS '公用数据';

CREATE TABLE "public"."tenant" (
  "id" int2 NOT NULL GENERATED ALWAYS AS IDENTITY (
INCREMENT 1
MINVALUE  1
MAXVALUE 32767
START 1
),
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "url" varchar(255) COLLATE "pg_catalog"."default",
  "driver_class_name" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default",
  "pool_name" varchar(255) COLLATE "pg_catalog"."default",
  CONSTRAINT "tenant_pkey" PRIMARY KEY ("id")
)
;

ALTER TABLE "public"."tenant" 
  OWNER TO "postgres";

COMMENT ON COLUMN "public"."tenant"."id" IS '主键';

COMMENT ON COLUMN "public"."tenant"."name" IS '租户名称';

COMMENT ON COLUMN "public"."tenant"."url" IS '数据库连接';

COMMENT ON COLUMN "public"."tenant"."driver_class_name" IS '数据库驱动';

COMMENT ON COLUMN "public"."tenant"."username" IS '用户名';

COMMENT ON COLUMN "public"."tenant"."password" IS '密码';

COMMENT ON COLUMN "public"."tenant"."pool_name" IS '连接池名称';

COMMENT ON TABLE "public"."tenant" IS '租户表';