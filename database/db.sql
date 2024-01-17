CREATE TABLE PricingRules
(
    SKU                CHAR(1) PRIMARY KEY,
    UnitPrice          DECIMAL(10, 2),
    DiscountUnits      INTEGER(3),
    DiscountPrice      DECIMAL(10, 2)
);

INSERT INTO PricingRules (SKU, UnitPrice, DiscountUnits, DiscountPrice)
VALUES ('A', 50, 3, 130),
       ('B', 30, 2, 45),
       ('C', 20, NULL, NULL),
       ('D', 15, NULL, NULL);