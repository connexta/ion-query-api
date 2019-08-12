# Query API
## Prerequisites
* Java 11

## Building
```bash
mvn clean install
```

## License Validation
The license headers are checked when you perform `mvn clean install`,
but if you want to do a standalone check:
```bash
mvn license:check
```
and to apply the header in `license-header.txt`:
```bash
mvn license:format
```