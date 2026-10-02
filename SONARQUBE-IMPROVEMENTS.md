# 30 Seconds of Java — SonarQube 代码质量改进记录

# 30 Seconds of Java — SonarQube Code Quality Improvement Log

> 更新日期 / Last updated: 2026-10-02
> 维护者 / Maintainers: 马斌 (MaBin) + Codex

---

## 0. 这份文档是做什么的 / What is this document for?

**中文**：这份文档用通俗的语言，一步一步记录我们为提升代码质量所做的每一处改动。每一条改动都会写清楚四件事：**改了什么、为什么改、怎么验证、出问题怎么退回**。即使你不熟悉 Git 和 SonarQube，也应该能看懂。全文中英双语对照。

**English**: This document records, in plain language, every change we make to improve the code quality of this project. For each change, four things are explained: **what changed, why, how it was verified, and how to roll back**. It is written bilingually (Chinese + English) so that anyone on the team can follow along, even without deep Git or SonarQube knowledge.

---

## 1. 任务目标 / Goals

来自任务的 5 项目标（对应 SonarQube 上要达成的指标）：

The five goals from the assignment (the metrics to reach on SonarQube):

| # | 目标（中文） | Goal (English) | 状态 / Status |
|---|--------------|----------------|---------------|
| 1 | 分析并修复项目中所有已识别的 Bug | Analyze and resolve all identified bugs | 🚧 进行中：基线发现 1 个真实 Bug / In progress: 1 real bug found at baseline |
| 2 | 调查并修复 SonarQube 标记的所有安全漏洞 | Investigate and address all security vulnerabilities flagged by SonarQube | ⏳ 未开始 / Not started |
| 3 | 优先处理并把技术债降到 30 分钟以内 | Prioritize and reduce the technical debt to 30 minutes or less | ⏳ 未开始 / Not started |
| 4 | 把行覆盖率提升到至少 95% | Increase the line coverage to at least 95% | 🚧 基线 85.14%，目标 95%+ / Baseline 85.14%, target 95%+ |
| 5 | 引入 SonarLint 来加速整个流程 | Incorporate SonarLint to speed up the process | ⏳ 未开始 / Not started |

---

## 2. 改动记录 / Change Log

> 规则 / Rule: 每次改动单独编号，只追加、不删改历史记录（除非是更正笔误）。
> Each change gets its own numbered entry; we only append, we do not rewrite history (except to fix typos).

### 改动 1：把项目备份到 GitHub / Change 1: Back up the project to GitHub

**日期 / Date**: 2026-10-02

**改了什么 / What changed**

- 调整了本地 Git 的"远程仓库"设置（远程仓库 = 项目在网上的备份地址）：
  - `origin`（默认远程）原来指向原作者的仓库 `iluwatar/30-seconds-of-java`，现在改为指向你自己的仓库 `BinBinnnnn/30s-of-java`；
  - 原作者的仓库改名为 `upstream`，以后可以随时从它同步官方更新，两者互不影响。
- 把当时的项目状态（提交 `1650b1d`）完整推送到你的 GitHub 仓库。
- 打了一个备份标签 `backup-before-sonar-2026-10-02`，相当于游戏里的"存档点"，随时可以回到这个状态。

- Adjusted the local Git "remote" configuration (a remote is the online copy of the project):
  - `origin` (the default remote) used to point to the original author's repository `iluwatar/30-seconds-of-java`; it now points to your own repository `BinBinnnnn/30s-of-java`;
  - The original author's repository was renamed to `upstream` so official updates can still be fetched later without interfering with your copy.
- Pushed the project state at that moment (commit `1650b1d`) to your GitHub repository.
- Created a backup tag `backup-before-sonar-2026-10-02` — like a save point in a game, you can return to it at any time.

**为什么 / Why**

**中文**：开始改代码之前先"留底"。之后任何一步出错，都可以一键回到干净的状态，不会丢东西。

**English**: Take a snapshot before touching any code. If anything goes wrong later, we can jump back to a clean state without losing anything.

**怎么验证 / How to verify**

打开 <https://github.com/BinBinnnnn/30s-of-java>，应该能看到 `master` 分支和名为 `backup-before-sonar-2026-10-02` 的标签。
Open <https://github.com/BinBinnnnn/30s-of-java>; you should see the `master` branch and the tag `backup-before-sonar-2026-10-02`.

**怎么退回 / How to roll back**

```bash
git switch master
git reset --hard backup-before-sonar-2026-10-02   # 谨慎：会丢弃之后的所有改动
```

**备注 / Notes**

**中文**：本地项目原本是"浅克隆"（只有 1 个提交、没有完整历史），会导致推送失败。已补全为完整历史（共 303 个提交）后成功推送。

**English**: The local copy was originally a "shallow clone" (only one commit, no full history), which made the push fail. We fetched the full history (303 commits in total) and the push then succeeded.

---

### 改动 2：同步原作者最新版 + 新建工作分支 / Change 2: Sync with the latest upstream version + create a work branch

**日期 / Date**: 2026-10-02

**改了什么 / What changed**

- 把项目"快进"到原作者的最新版本（从 `1650b1d` 更新到 `f0c0c04`）。这次更新只是新增内容，没有修改任何已有文件：
  1. `localization/fr/README.md` — 法语版本说明文档；
  2. `src/main/java/cls/SafeCastSnippet.java`（含测试）— 安全类型转换代码片段；
  3. `src/main/java/system/GetEnvOrDefaultSnippet.java`（含测试）— 读取环境变量并支持默认值的代码片段。
- 新建工作分支 `codex/sonarqube-quality`。**之后所有的质量改进行动都发生在这个分支上**，`master` 分支保持和备份一致，随时可以对照、回滚。

- Fast-forwarded the project to the original author's latest version (from `1650b1d` to `f0c0c04`). This update only added new content; no existing file was modified:
  1. `localization/fr/README.md` — French localization of the documentation;
  2. `src/main/java/cls/SafeCastSnippet.java` (with tests) — a safe type-casting snippet;
  3. `src/main/java/system/GetEnvOrDefaultSnippet.java` (with tests) — a snippet that reads an environment variable with a default value.
- Created the work branch `codex/sonarqube-quality`. **All quality-improvement work happens on this branch**; the `master` branch stays aligned with the backup so we can always compare or roll back.

**为什么 / Why**

**中文**：SonarQube 的分析结果是针对最新代码的，用最新版开工，问题清单才对得上，避免改到已经变化的代码。用单独分支工作，出错时只需切换回 `master` 就能回到干净状态。

**English**: SonarQube analyzes the latest code, so starting from the latest version keeps our fix list consistent with the reported issues. Working on a separate branch means that if anything goes wrong, switching back to `master` restores the clean state.

**怎么验证 / How to verify**

```bash
git log --oneline -1        # 应显示 f0c0c04 docs: add French localization (#269)
git branch --show-current   # 应显示 codex/sonarqube-quality
```

**怎么退回 / How to roll back**

```bash
git switch master           # 回到备份状态，工作分支原样保留
```

---

### 改动 3：基线诊断（本地构建 + 覆盖率） / Change 3: Baseline diagnostics (local build + coverage)

**日期 / Date**: 2026-10-02

**做了什么 / What was done**

**中文**：在与原作者完全一致的最新代码（`f0c0c04`）上，运行了一次完整的本地构建，包含：编译、全部单元测试、Checkstyle 代码规范检查、JaCoCo 覆盖率统计。目的：得到一份"改动前的体检报告"，作为对照基线。

**English**: A full local build was run on the latest upstream code (`f0c0c04`), including compilation, all unit tests, Checkstyle style checks, and JaCoCo coverage. The purpose is to get a "health report before changes" as a baseline for comparison.

**结果 / Results**

| 检查项 / Check | 结果 / Result | 说明 / Notes |
|----------------|---------------|--------------|
| 编译 Compilation | ✅ 通过 Pass | 77 个源码类 / 77 main classes |
| Checkstyle 代码规范 | ✅ 0 违规 / 0 violations | 主代码与测试代码均通过 / both main and test pass |
| 单元测试 Unit tests | ❌ 238 个用例中 1 个失败 / 1 of 238 failed | `system.GetEnvOrDefaultSnippetTest.testPresentEnvironmentVariable` |
| 行覆盖率 Line coverage | 🚧 85.14%（636 / 747 行） | 距离 95% 目标还差约 74 行 / about 74 lines short |
| 分支覆盖率 Branch coverage | 87.44% | 参考值 / reference only |

**基线发现的第一个真实 Bug（对应任务 1）/ First real bug found (maps to Goal 1)**

**中文**：`GetEnvOrDefaultSnippet` 读环境变量用的是 `System.getenv().getOrDefault("PATH", 默认值)`。问题在于：Windows 上环境变量在系统里的名字是 `Path`（大小写不同），而 `System.getenv()` 返回的是"大小写敏感"的字典，于是取 `"PATH"` 会取不到、错误地返回默认值；但同一台机器上 `System.getenv("PATH")` 又是"大小写不敏感"的、能取到。这个不一致导致它自带的测试在 Windows 上失败、在 Linux CI 上却通过。修复方向：改用 `System.getenv(key)`（大小写不敏感、跨平台一致）再判空。

**English**: `GetEnvOrDefaultSnippet` reads environment variables with `System.getenv().getOrDefault("PATH", default)`. On Windows the variable is stored as `Path`, and the map returned by `System.getenv()` is key-case-sensitive, so `"PATH"` is not found and the default is returned by mistake - while `System.getenv("PATH")` in the same JVM is case-insensitive and does find it. This inconsistency makes the snippet's own test fail on Windows but pass on Linux CI. Fix direction: use `System.getenv(key)` (case-insensitive and consistent across platforms) and null-check the result.

**覆盖率结构分析 / Coverage breakdown**

**中文**：111 行未覆盖中，有 77 行来自 75 个"工具类"从未被实例化（Java 会给每个类生成隐式构造函数，JaCoCo 会把它记为 1 行未覆盖），只有 34 行是真正的业务逻辑未覆盖。这两类缺口要用不同办法解决。

**English**: Of the 111 uncovered lines, 77 come from 75 "utility classes" that are never instantiated (Java generates an implicit constructor for each class and JaCoCo records it as one uncovered line). Only 34 lines are genuinely uncovered logic. These two kinds of gaps need different solutions.

**怎么验证 / How to verify**

```powershell
cd C:\tmp\30s-project
$env:GRADLE_USER_HOME='C:\tmp\gradle-home'
.\gradlew.bat build --no-daemon --console=plain
```

覆盖率报告 / Coverage report: `build/reports/jacoco/test/html/index.html`
测试报告 / Test report: `build/reports/tests/test/index.html`

**备注 / Notes**

**中文**：本机项目路径含中文（`C:\Users\马斌\...`），会让 Gradle 派生的测试进程读不到类路径（表现为"找不到测试类"）。这不影响代码本身，只影响本机运行方式，绕开办法见第 5 节。另外，终端里看到的源码版权头乱码只是显示问题，文件本身是正常的 UTF-8。

**English**: The local project path contains Chinese characters (`C:\Users\马斌\...`), which prevents Gradle's forked test process from reading the classpath (symptom: "test class not found"). This is a local-run environment issue, not a code problem; the workaround is in section 5. Also, the garbled copyright header seen in the terminal is only a display artifact - the files themselves are valid UTF-8.

---
### 改动 4：保存 SonarCloud 基线分析结果 / Change 4: Save the SonarCloud baseline analysis results

**日期 / Date**: 2026-10-02

**做了什么 / What was done**

**中文**：
- 在项目里新建 `quality-reports/` 文件夹，把这次分析的全部结果存档：
  - `sonar-baseline-report.md` —— 完整可读报告：指标总览、5 个 Bug 明细、111 个代码坏味道明细、规则速查表、本地测试与覆盖率基线、复现命令；
  - `sonar-baseline-issues.json` —— SonarCloud 返回的原始问题清单（116 条，机器可读）；
  - `sonar-baseline-measures.json` —— 指标原始数据；
  - `sonar-baseline-quality-gate.json` —— 质量门状态。
- 修改 `build.gradle` 里的分析目标：`sonar.projectKey` 和 `sonar.organization` 由原作者组织（iluwatar）改为你自己的 SonarCloud 项目（`BinBinnnnn_30s-of-java` / `binbinnnnn`）。以后本地扫描和你仓库的 GitHub Actions 都会把结果上传到**你自己的**项目面板。
- 在 SonarCloud 网页上关闭了项目的"Automatic Analysis（自动分析）"开关（它不带测试覆盖率，且与完整扫描冲突）。

**English**:
- Created a `quality-reports/` folder and archived the full analysis results:
  - `sonar-baseline-report.md` - the full readable report: metrics overview, the 5 bugs, all 111 code smells, a rule reference table, the local test & coverage baseline, and reproduction commands;
  - `sonar-baseline-issues.json` - the raw issue list returned by SonarCloud (116 issues, machine readable);
  - `sonar-baseline-measures.json` - raw metric data;
  - `sonar-baseline-quality-gate.json` - quality gate status.
- Changed the analysis target in `build.gradle`: `sonar.projectKey` and `sonar.organization` were switched from the original author's organization (iluwatar) to your own SonarCloud project (`BinBinnnnn_30s-of-java` / `binbinnnnn`). From now on, both local scans and your repository's GitHub Actions upload results to **your own** dashboard.
- Turned off the project's "Automatic Analysis" switch on the SonarCloud website (it does not include test coverage and conflicts with the full analysis).

**为什么 / Why**

**中文**：把"修复前"的完整证据保存下来，方便对照修复效果、回看细节、写作业报告。配置改成你自己的项目，是为了让指标真实反映你的仓库，而不是原作者的项目。

**English**: To keep the complete "before" evidence for comparison, review, and the assignment report. The configuration change makes the metrics reflect your own repository instead of the original author's project.

**怎么验证 / How to verify**

- 打开 `quality-reports/sonar-baseline-report.md` 查看全部明细；
- 打开 <https://sonarcloud.io/project/overview?id=BinBinnnnn_30s-of-java> 查看在线面板。

---
## 3. 通用回滚方法 / General Rollback Guide

| 想退回到哪里 / Go back to | 命令 / Command |
|--------------------------|----------------|
| 备份快照（改动之前）/ The backup snapshot (before any change) | `git switch master` |
| 某一次具体提交 / A specific commit | `git log --oneline` 找到编号后 / find the hash, then `git switch <hash>` |
| 撤销某个文件的本地修改 / Discard local edits of a file | `git restore <文件路径 / file path>` |

**中文**：任何时候都可以先执行 `git log --oneline` 查看所有"存档点"，再决定退回哪里。真正执行"丢弃改动"的命令（如 `git reset --hard`）之前，一定要先确认。

**English**: At any time, run `git log --oneline` to list all save points before deciding where to go. Always double-check before running commands that discard work, such as `git reset --hard`.

---

## 4. 名词小词典 / Mini Glossary

| 名词 / Term | 通俗解释（中文） | Plain explanation (English) |
|-------------|------------------|------------------------------|
| Git | 代码的"时间机器"，记录每一次修改 | A time machine for code; it records every change |
| 提交 / commit | 一次存档 | One save point |
| 标签 / tag | 给某个存档起的名字，方便找回 | A readable name for a save point |
| 分支 / branch | 平行世界；在分支上改动，不影响主线 | A parallel world; changes there do not affect the main line |
| origin / upstream | 默认远程仓库 / 官方原仓库 | Your default remote repository / the official original repository |
| SonarQube | 自动检查代码的"体检仪"，会报告 Bug、安全漏洞、技术债 | An automatic code "health checker" reporting bugs, vulnerabilities, and technical debt |
| 技术债 / Technical debt | 代码中"欠下的账"，修起来要花的时间（Sonar 用分钟表示） | The "debt" hidden in code, measured by the time needed to fix it |
| 覆盖率 / Coverage | 测试跑过的代码比例，越高说明测试越全面 | The share of code executed by tests; higher means better tested |
| SonarLint | 装在编辑器里的"实时体检插件"，边写边提醒 | A real-time checker plug-in for the IDE |
| JaCoCo | 生成覆盖率报告的 Java 工具 | The Java tool that produces coverage reports |

---

## 5. 本机运行小贴士 / Local Build Tips

**中文**：这台电脑的用户目录名含中文，直接在本项目目录里运行 Gradle 构建时，测试进程会报"找不到测试类"。解决办法是绕开中文路径，用一个"英文快捷方式"（目录联接）来运行。已创建好，无需重复操作：

**English**: This computer's user folder name contains Chinese characters, so running Gradle directly in the project folder makes the test process fail with "test class not found". The workaround is to run from an ASCII shortcut (a directory junction). It has already been created - no need to recreate it:

| 联接 / Junction | 指向 / Points to | 用途 / Purpose |
|-----------------|------------------|----------------|
| `C:\tmp\30s-project` | 项目目录 / the project folder | 从这里运行构建 / run builds from here |
| `C:\tmp\gradle-home` | `C:\Users\马斌\.gradle` | Gradle 缓存也走英文路径 / Gradle cache via ASCII path |

日常构建命令 / Everyday build command:

```powershell
cd C:\tmp\30s-project
$env:GRADLE_USER_HOME='C:\tmp\gradle-home'
.\gradlew.bat build --no-daemon --console=plain
```

**中文**：如果以后把项目移动到纯英文路径（例如 `D:\projects\30-seconds-of-java`），就不再需要这些联接了。

**English**: If the project is later moved to a pure-ASCII path (for example `D:\projects\30-seconds-of-java`), these junctions are no longer needed.