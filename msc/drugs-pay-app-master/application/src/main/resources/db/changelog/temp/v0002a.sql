CREATE TABLE drugs_app.db_state_info (
  Dsi_Id            BIGINT(20)  NOT NULL   AUTO_INCREMENT,
  Dsi_Code          VARCHAR(4)  NOT NULL,
  Dsi_Name          VARCHAR(15) NOT NULL,
  Dsi_CreatedBy     VARCHAR(32) NOT NULL,
  Dsi_UpdatedBy     VARCHAR(32) NOT NULL,
  Dsi_CreatedDate   DATETIME    NOT NULL,
  Dsi_UpdateDate    DATETIME    NOT NULL,
  PRIMARY KEY (Dsi_Id)
);

INSERT INTO drugs_app.db_state_info (Dsi_Code, Dsi_Name, Dsi_CreatedBy, Dsi_UpdatedBy, Dsi_CreatedDate, Dsi_UpdateDate) VALUES
  ('PL', 'Philadelphia', '1', '1', '2000-01-01', '2000-01-01'),
  ('WS', 'Washington', 'a', '1', '2000-01-01', '2000-01-02');