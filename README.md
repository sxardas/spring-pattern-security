# 🛡️ Spring Pattern Security

A personal project exploring security patterns, authentication flows, and authorization mechanisms in Spring Boot.

The repository contains independent implementations of different security patterns and approaches, each organized as a
separate module in the root directory.


### 🧩 Patterns & Implementations

| Pattern / Module                                                                   | Description                                                                                                                                                                                                                         | Key Components                                            |
|:-----------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:----------------------------------------------------------|
| [**Authorization Code Flow with PKCE**](pattern-authorization-code-pkce/README.md) | Decoupled OAuth 2.0 architecture where a public client (SPA/Mobile) authenticates directly with Keycloak using PKCE and stores tokens locally, while Spring Boot purely validates Bearer JWT tokens as a stateless Resource Server. | Nginx, Keycloak, Spring Security (OAuth2 Resource Server) |

> Work in progress. The implementation is still being developed.

---

<div align="center">
  <sub>Built for learning, experimenting, and exploring Spring Security under the hood ;)</sub>
</div>
