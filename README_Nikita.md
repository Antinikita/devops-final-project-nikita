DevOps Project: Full Cycle Automation (Nikita)

Данный проект представляет собой полностью автоматизированную систему развертывания веб-приложения (Spring Boot + PostgreSQL) с использованием современных DevOps инструментов.
1. Архитектура системы (Architecture)

Проект построен на базе микросервисного подхода:

    Backend: Java Spring Boot (Task Manager API).

    Database: PostgreSQL (StatefulSet/Deployment в K8s).

    CI/CD: Jenkins (Pipeline as Code).

    IaC: Ansible (Roles, Handlers, Vault).

    Orchestration: Kubernetes (Deployments, Services, Secrets, HPA).

2. CI/CD Pipeline Flow

Автоматизация сборки и доставки (Jenkinsfile):

    Checkout: Клонирование репозитория.

    Build: Сборка .jar файла через Maven.

    Docker Push: Сборка образа и отправка на Docker Hub (тегирование).

    K8s Deploy: Обновление манифестов и перезапуск подов в кластере.

3. Автоматизация инфраструктуры (Ansible)

Инфраструктура настраивается одной командой:
Bash

ansible-playbook -i ansible/inventory_Nikita.ini ansible/site_Nikita.yml --ask-vault-pass

Что автоматизировано:

    Установка Docker и системных утилит (kubectl, minikube).

    Настройка прав доступа (группы пользователей).

    Шифрование секретов (пароли БД) через Ansible Vault.

    Копирование и применение манифестов Kubernetes.

4. Инструкция по развертыванию (Setup)

   Подготовка: Запустить Ansible плейбук для настройки среды.

   Сборка: Запустить пайплайн в Jenkins.

   Доступ: После успешного деплоя пробросить порт:
   Bash

   kubectl port-forward deployment/app-deployment-nikita 8080:8080

   Проверка: Открыть http://localhost:8080/api/nikita/tasks.

5. Верификация (Verification Evidence)
   5.1 Jenkins Pipeline

(Здесь вставь скриншот зеленого Jenkins пайплайна)

    Описание: Подтверждает успешное прохождение всех стадий сборки и пуша образа.

5.2 Kubernetes Status

(Здесь вставь скриншот вывода команды kubectl get pods,svc)

    Описание: Все поды (App и DB) находятся в статусе Running, сервисы созданы.

5.3 REST Endpoint Output (JSON)

(Здесь вставь тот самый "солидный" скриншот браузера с JSON-ом)

    Описание: Приложение успешно подключилось к PostgreSQL и возвращает данные через API.

5.4 Ansible Play Recap

(Здесь вставь скриншот терминала, где failed=0)

    Описание: Подтверждает идемпотентность и корректную работу ролей Ansible.

6. Используемые Best Practices

   Idempotency: Плейбуки Ansible можно запускать повторно без ошибок.

   Security: Использование K8s Secrets и Ansible Vault для паролей.

   Scalability: Настроен Horizontal Pod Autoscaler (HPA) для приложения.

   Separation of Concerns: Четкое разделение на роли в Ansible и стадии в Jenkins.