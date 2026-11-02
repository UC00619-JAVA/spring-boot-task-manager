UC00619 — Desenvolvimento em Java — Sessão 10
Desafio final — Gestor de tarefas em camadas
Projeto: tasks  ·  Spring Boot 4.1.2 · Java 21 · Maven · Lombok
================================================================

CODE:

Priority        enum LOW, MEDIUM, HIGH (sessão 6)
Task            @Data @NoArgsConstructor @AllArgsConstructor @Builder (id, title, priority, done)
AppConfig       @Configuration com um @Bean DateTimeFormatter ("dd-MM-yyyy")
TaskRepository  @Repository; @PostConstruct carrega 4 tarefas de exemplo com o builder; @Slf4j
TaskService     @Service @RequiredArgsConstructor: recebe o TaskRepository e o DateTimeFormatter;
                    getAll(), getPending() (ciclo for, sem streams — sessão 13) e getSummary()
TaskController  @RestController @RequiredArgsConstructor: GET /tasks, /tasks/pending, /tasks/summary

RESULTADO ESPERADO:

    Log ao arrancar:  INFO ... TaskRepository : 4 sample tasks loaded
    http://localhost:8080/tasks          → as 4 tarefas em JSON, ex.:
        {"id":1,"title":"Install the JDK 21","priority":"HIGH","done":true}
    http://localhost:8080/tasks/pending  → as tarefas 3 e 4
    http://localhost:8080/tasks/summary  → Summary for 09-11-2026: 4 tasks, 2 pending  (com a data de hoje)

    Para ver o log DEBUG de getPending: logging.level.com.example.tasks=DEBUG no application.properties.