
  CREATE TABLE db_user (
    Dur_Id       BIGINT(20)  NOT NULL   AUTO_INCREMENT,
    Dur_Name     VARCHAR(32) NOT NULL,
    Dur_Email    VARCHAR(32) NOT NULL,
    Dur_Password VARCHAR(32) NOT NULL,
    Dur_Salt     VARCHAR(32) NOT NULL,

    PRIMARY KEY (Dur_Id)
  );

  CREATE TABLE db_state_info (
    Dsi_Id            BIGINT(20)  NOT NULL   AUTO_INCREMENT,
    Dsi_Code          VARCHAR(4)  NOT NULL,
    Dsi_Name          VARCHAR(15) NOT NULL,
    PRIMARY KEY (Dsi_Id)
  );

  CREATE TABLE db_product_info (
  Dpr_Id            BIGINT(20)  NOT NULL   AUTO_INCREMENT,
  Dpr_Name          VARCHAR(15) NOT NULL,
  Dpr_Dsi_State     BIGINT(20)  DEFAULT NULL,
  PRIMARY KEY (Dpr_Id)
  ,
  FOREIGN KEY (Dpr_Dsi_State) REFERENCES db_state_info (Dsi_Id)
    ON UPDATE CASCADE
    ON DELETE SET NULL
  );

  CREATE TABLE db_patient_info (
      Dpi_Id            BIGINT(20)  NOT NULL   AUTO_INCREMENT,
      Dpi_Phone         BIGINT(20)  NOT NULL,
      Dpi_Dsi_State     BIGINT(20)  DEFAULT NULL,
    PRIMARY KEY (Dpi_Id),
    FOREIGN KEY (Dpi_Dsi_State) REFERENCES db_state_info (Dsi_Id)
      ON UPDATE CASCADE
      ON DELETE SET NULL
  );

CREATE TABLE db_transaction (
  Dtr_Id            BIGINT(20)     NOT NULL    AUTO_INCREMENT,
  Dtr_Dpi_Patient   BIGINT(20)     NOT NULL,
  Dtr_Dpr_Product   BIGINT(20)     NOT NULL,
  Dtr_Date          DATETIME       NOT NULL,
  PRIMARY KEY (Dtr_Id)
  ,
  FOREIGN KEY (Dtr_Dpi_Patient) REFERENCES db_patient_info (Dpi_Id),
  FOREIGN KEY (Dtr_Dpr_Product) REFERENCES db_product_info (Dpr_Id)
);

  CREATE TABLE db_audit_operation (
     Dao_Id            BIGINT(20)     NOT NULL   AUTO_INCREMENT,
     Dao_Date          DATETIME       NOT NULL,
     Dao_Status        BOOLEAN        NOT NULL,
     Dao_Action        LONGTEXT       NOT NULL,
     PRIMARY KEY (Dao_Id)
   );

  INSERT INTO db_user
  (Dur_Name, Dur_Email, Dur_Password, Dur_Salt) VALUES
    ('a', 'b', '92eb5ffee6ae2fec3ad71c777531578f', '0cc175b9c0f1b6a831c399e269772661'),
    ('1', '2', 'c81e728d9d4c2f636f067f89cc14862c', 'c4ca4238a0b923820dcc509a6f75849b');

  INSERT INTO db_state_info
  (Dsi_Code, Dsi_Name) VALUES
    ('PL', 'Philadelphia'),
    ('WS', 'Washington');

  INSERT INTO db_product_info
  (Dpr_Name, Dpr_Dsi_State) VALUES
    ('pervin', 1),
    ('revit', 2),
    ('dxm', 2);

  INSERT INTO db_patient_info
  (Dpi_Phone, Dpi_Dsi_State) VALUES
    (333123, 1),
    (366666, 2),
    (123455, 2);

