# Data Fusion API

This project provides REST API endpoints for data access and manipulation.

## API Endpoints

### 1. GET /api/get_data
- Method: GET
- Authentication: Basic Auth (username/password)
- Credentials: admin/nimda
- Parameters:
  - page: Page number (default: 0)
  - size: Page size (default: 10)

Example:
```bash
curl -X GET http://localhost:8080/api/get_data \
  -u admin:nimda
```

### 2. POST /api/post_data
- Method: POST
- Authentication: JWT Token
- Token: Bearer token in Authorization header

Example:
```bash
curl -X POST http://localhost:8080/api/post_data \
  -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
```

## Running with Docker

### Prerequisites
- Docker
- PostgreSQL database (external)

### Steps to Run

1. Clone the repository:
```bash
git clone <repository-url>
cd data_fusion
```

2. Build the Docker image:
```bash
docker build -t 513180854/data_fusion_app:1.1 .
```

3. Run the container:
```bash
docker run -d -p 18082:8080 \
  -e POSTGRES_URL=jdbc:postgresql://192.168.80.20:5432/api \
  -e POSTGRES_USER=root \
  -e POSTGRES_PASSWORD=root \
  -e JWT_SECRET=9a4f2c8d3b7a1e6f45c8a0b3f267d8b1d4e6f3c8a9d2b5f8e3a9c6b5d2e8f1a \
  -e JWT_EXPIRATION=86400000 \
  --name data_fusion_app_debug \
  513180854/data_fusion_app:1.1
```

4. Check the logs:
```bash
docker logs -f data_fusion_app
```

5. Access the API:
   - GET endpoint: http://localhost:8080/api/get_data
   - POST endpoint: http://localhost:8080/api/post_data

### Stopping the Application

To stop the application:
```bash
docker stop data_fusion_app
docker rm data_fusion_app
```

## DataX Integration

This project can be integrated with DataX for data synchronization. Sample DataX job configurations are provided in the `jobs` directory:

- `get_data_job.json`: For fetching data from the API
- `get_data_pages_job.json`: For fetching paginated data from the API
- `post_data_job.json`: For posting data to the API

## Response Format
Both endpoints return JSON array of objects with the following structure:
```json
[
  {
    "cid": 1,
    "name": "example"
  }
]
``` 