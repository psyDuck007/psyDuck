# psyDuck
可达鸭007

## Demo: 将网页内容保存为本地txt (Spring Boot)

1. 构建并运行:
   ```bash
   mvn package
   java -jar target/psyduck-0.0.1-SNAPSHOT.jar
   ```
2. 触发保存:
   ```bash
   curl "http://localhost:8080/save?url=https://www.example.com&file=example.txt"
   ```
   应用会提取页面中的段落文字并写入到 `example.txt` 文件中。
