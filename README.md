
# Kata09: Back to the Checkout

## Project Overview

This Java project is an implementation of the coding challenge described at [Kata09: Back to the Checkout](http://codekata.com/kata/kata09-back-to-the-checkout/).

## Features

- **Flexible Pricing Rules**: Easily configure pricing rules for each product in the database.
- **Scalable Design**: Add new products and pricing schemes without altering existing code.
- **Robust Testing**: Ensures the reliability of the checkout system through test coverage.

## Getting Started

### Prerequisites

- Java 8 or later.
- Gradle for building and running the project.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/mpgallage/Kata09.git
   ```

2. Navigate to the project directory:
   ```bash
   cd Kata09
   ```

3. Build the project using Gradle:
   ```bash
   .gradlew clean build
   ```

4. Run tests using Gradle:
   ```bash
   .gradlew test
   ```

## Database Schema and Data - `checkout.sqlite`

### Schema

The database contains a single table named `PricingRules`. This table is designed to store pricing information for various products, identified by their Stock Keeping Unit (SKU).

#### Table: `PricingRules`

| Column         | Data Type          | Description                                        |
|----------------|--------------------|----------------------------------------------------|
| `SKU`          | CHAR(1)            | Primary key. A unique identifier for each product. |
| `UnitPrice`    | DECIMAL(10, 2)     | The standard unit price of the product.            |
| `DiscountUnits`| INTEGER(3)         | The quantity of items required for a discount.     |
| `DiscountPrice`| DECIMAL(10, 2)     | The total price for the discounted quantity.       |

### Data

Initial data is populated into the `PricingRules` table as follows:

- **SKU 'A'**: Priced at $50 each, with a special deal of 3 for $130.
- **SKU 'B'**: Priced at $30 each, with a special deal of 2 for $45.
- **SKU 'C'**: Priced at $20 each, with no special discount.
- **SKU 'D'**: Priced at $15 each, with no special discount.

### Database File

The database is stored in a SQLite file named `checkout.sqlite` inside the project directory.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Malaka Gallage - mpgallage@gmail.com

Project Link: [https://github.com/mpgallage/Kata09](https://github.com/mpgallage/Kata09)
