# 📱 Template de Projeto Android para Soluções Mobile

Este template fornece uma base estruturada para novos projetos Android na disciplina de Soluções Mobile.

## 🚀 Como usar este template

1. **Copiar o template**:
   ```bash
   cp -r android-projects/templates/android-basic android-projects/aulaXX/
   cd android-projects/aulaXX/
   ```

2. **Personalizar configurações**:
   - Editar `settings.gradle.kts` - alterar `rootProject.name`
   - Editar `app/build.gradle.kts` - alterar `namespace` e `applicationId`
   - Renomear pacotes em `app/src/main/java/br/satc/`

3. **Implementar funcionalidades**:
   - Adicionar telas em `ui/screens/`
   - Criar componentes em `ui/components/`
   - Definir modelos em `models/`

## 📁 Estrutura Base

```
aulaXX/
├── app/
│   ├── build.gradle.kts
│   ├── proguard-rules.pro
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/br/satc/[projeto]/
│       │   ├── MainActivity.kt
│       │   ├── ui/
│       │   │   ├── theme/
│       │   │   ├── screens/
│       │   │   └── components/
│       │   ├── models/
│       │   └── utils/
│       └── res/
│           ├── values/
│           └── drawable/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
└── docs/
    └── README.md
```

## 🛠️ Tecnologias Incluídas

- **Jetpack Compose** - UI declarativa
- **Material Design 3** - Design system moderno
- **Kotlin** - Linguagem principal
- **Gradle Kotlin DSL** - Sistema de build

## 📚 Convenções

- **Packages**: Snake case em português (ex: `pedra_papel_tesoura`)
- **Classes**: Pascal case em português (ex: `JogoPrincipal`)
- **Composables**: Pascal case (ex: `TelaInicial`)
- **Variáveis**: Camel case em português (ex: `estadoJogo`)
