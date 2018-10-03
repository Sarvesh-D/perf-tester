# perf-tester

Spring Boot 2.0.5 and micrometer based app which uses Spring's Reactive web client to apply load test on `/user/bulk` API. The metrics are reported to Prometheus and visualized on Grafana to get insights on through-put, etc.

## To start performance test and visualize on grafana
1. run start.bat
1. visit [Grafana](http://localhost:3000/d/lblq4y0ik/perf-tester?orgId=1&from=now-5m&to=now) to see the performance results
