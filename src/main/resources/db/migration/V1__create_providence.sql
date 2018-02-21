CREATE TABLE IF NOT EXISTS loudness (
  id            INT(11)      NOT NULL AUTO_INCREMENT,
  uid           INT(11)      NOT NULL COMMENT 'ユーザID',
  unixtime      BIGINT       NOT NULL COMMENT 'UNIX時間',
  loudness      INT(11)      NOT NULL COMMENT '声の大きさ',
  created_at    TIMESTAMP DEFAULT current_timestamp() COMMENT 'レコードの作成日時',
  PRIMARY KEY (id),
  INDEX (uid, unixtime)
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 DEFAULT COLLATE utf8mb4_bin COMMENT '声の大きさ';

CREATE TABLE IF NOT EXISTS expression (
  id            INT(11)      NOT NULL AUTO_INCREMENT,
  uid           INT(11)      NOT NULL COMMENT 'ユーザID',
  unixtime      BIGINT       NOT NULL COMMENT 'UNIX時間',
  expression    INT(1)       NOT NULL COMMENT '表情（0〜6）',
  created_at    TIMESTAMP DEFAULT current_timestamp() COMMENT 'レコードの作成日時',
  PRIMARY KEY (id),
  INDEX (uid, unixtime)
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 DEFAULT COLLATE utf8mb4_bin COMMENT '表情';

CREATE TABLE IF NOT EXISTS direction (
  id            INT(11)      NOT NULL AUTO_INCREMENT,
  uid           INT(11)      NOT NULL COMMENT 'ユーザID',
  unixtime      BIGINT       NOT NULL COMMENT 'UNIX時間',
  direction     INT(1)       NOT NULL COMMENT '向いている方向（0〜6）',
  created_at    TIMESTAMP DEFAULT current_timestamp() COMMENT 'レコードの作成日時',
  PRIMARY KEY (id),
  INDEX (uid, unixtime)
) ENGINE InnoDB DEFAULT CHARSET utf8mb4 DEFAULT COLLATE utf8mb4_bin COMMENT '向いている方向';