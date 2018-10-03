start "Prometheus" /D prometheus-2.4.2.windows-amd64 prometheus.exe
start "Grafana" /D "grafana-5.3.0-beta1/bin" grafana-server.exe
start "Perf Test" /D perf-tester gradle clean test
