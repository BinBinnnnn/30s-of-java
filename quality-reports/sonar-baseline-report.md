# SonarQube 基线分析报告 / SonarQube Baseline Analysis Report

> 分析日期 / Date: 2026-10-02  
> 项目 / Project: `BinBinnnnn_30s-of-java` (SonarCloud)  
> 代码版本 / Code revision: `f0c0c04`（原作者最新版）+ 本地分析配置改动  
> 项目面板 / Dashboard: <https://sonarcloud.io/project/overview?id=BinBinnnnn_30s-of-java>  
> 说明 / Note: 本文档保存的是**修复开始之前**的完整结果（存档）。修复完成后会另存一份对照报告。

---

## 1. 指标总览 / Metrics Overview

| 指标 Metric | 数值 Value |
|---|---|
| 覆盖率 Coverage (%) | 85.9 |
| 可靠性评级 Reliability Rating | 5.0 |
| 重复代码比例 Duplicated lines (%) | 0.0 |
| 代码坏味道 Code Smells | 111 |
| 安全性评级 Security Rating | 1.0 |
| 技术债比例 Debt Ratio (%) | 1.3 |
| 安全热点 Security Hotspots | 0 |
| 技术债（分钟）Technical Debt (min) | 573 |
| 可维护性评级 Maintainability Rating | 1.0 |
| Bugs 缺陷数 | 5 |
| 需要覆盖的行 Lines to cover | 747 |
| 分支覆盖率 Branch Coverage (%) | 87.4 |
| 未覆盖行 Uncovered lines | 111 |
| 代码行数 NCLOC | 1442 |
| 安全漏洞 Vulnerabilities | 0 |
| 行覆盖率 Line Coverage (%) | 85.1 |

## 2. Bugs 明细（5 个）/ Bugs in Detail

| 规则 Rule | 严重度 Severity | 文件 File:Line | Sonar 说明 | 通俗解释（中文） | 修复工时 |
|---|---|---|---|---|---|
| java:S5998 | MAJOR | src/main/java/string/CompareVersionSnippet.java:32 | Refactor this repetition that can lead to a stack overflow for large inputs. | 正则表达式不要写成会栈溢出的形式（长输入崩溃，Bug） | 20min |
| java:S9342 | CRITICAL | src/main/java/file/ZipDirectorySnippet.java:72 | Write content to this archive entry; it is empty. | 压缩包中不要写入空的条目内容（Bug） | 5min |
| java:S9342 | CRITICAL | src/main/java/file/ZipDirectorySnippet.java:76 | Write content to this archive entry; it is empty. | 压缩包中不要写入空的条目内容（Bug） | 5min |
| java:S2095 | BLOCKER | src/main/java/network/HttpGetSnippet.java:45 | Use try-with-resources or close this "HttpClient" in a "finally" clause. | 资源用完要关闭（资源泄漏，Bug） | 5min |
| java:S2095 | BLOCKER | src/main/java/network/HttpPostSnippet.java:66 | Use try-with-resources or close this "HttpClient" in a "finally" clause. | 资源用完要关闭（资源泄漏，Bug） | 5min |

## 3. 安全类问题 / Security

- 安全漏洞 Vulnerabilities: **0**
- 安全热点 Security Hotspots: **0**
- 说明：本次分析没有发现需要处理的安全问题；后续改动后每次复扫都会重新检查。

## 4. 代码坏味道明细（111 个）/ Code Smells in Detail

### java:S1118 — 工具类不应有公开构造函数：加一个私有构造函数，防止被 new （72 处 / 360 分钟）

需要新增私有构造函数的文件 / Files to add a private constructor:

- `src/main/java/algorithm/BinarySearchIn2dArraySnippet.java`
- `src/main/java/algorithm/BinarySearchSnippet.java`
- `src/main/java/algorithm/BubbleSortSnippet.java`
- `src/main/java/algorithm/CountingSortSnippet.java`
- `src/main/java/algorithm/CycleSortSnippet.java`
- `src/main/java/algorithm/InsertionSortSnippet.java`
- `src/main/java/algorithm/LinearSearchIn2dArraySnippet.java`
- `src/main/java/algorithm/LinearSearchSnippet.java`
- `src/main/java/algorithm/LuhnModnSnippet.java`
- `src/main/java/algorithm/MergeSortSnippet.java`
- `src/main/java/algorithm/QuickSortSnippet.java`
- `src/main/java/algorithm/SelectionSortSnippet.java`
- `src/main/java/algorithm/SieveOfEratosthenesSnippet.java`
- `src/main/java/algorithm/VerhoeffSnippet.java`
- `src/main/java/array/AllEqualSnippet.java`
- `src/main/java/array/ArrayConcatSnippet.java`
- `src/main/java/array/ArrayMeanSnippet.java`
- `src/main/java/array/ArrayMedianSnippet.java`
- `src/main/java/array/ArrayModeInPlaceSnippet.java`
- `src/main/java/array/ArraySumSnippet.java`
- `src/main/java/array/FindMaxSnippet.java`
- `src/main/java/array/FindMinSnippet.java`
- `src/main/java/array/MultiArrayConcatenationSnippet.java`
- `src/main/java/array/ReverseArraySnippet.java`
- `src/main/java/cls/CreatingObjectSnippet.java`
- `src/main/java/cls/GetAllFieldNamesSnippet.java`
- `src/main/java/cls/GetAllMethodsSnippet.java`
- `src/main/java/cls/GetAllPublicFieldNamesSnippet.java`
- `src/main/java/cls/SafeCastSnippet.java`
- `src/main/java/date/AddDaysToDateSnippet.java`
- `src/main/java/date/DateDifferenceSnippet.java`
- `src/main/java/encoding/Base64DecodeSnippet.java`
- `src/main/java/encoding/Base64EncodeSnippet.java`
- `src/main/java/file/ListAllFilesSnippet.java`
- `src/main/java/file/ListDirectoriesSnippet.java`
- `src/main/java/file/ListFilesInDirectorySnippet.java`
- `src/main/java/file/ReadLinesSnippet.java`
- `src/main/java/file/ZipDirectorySnippet.java`
- `src/main/java/file/ZipFileSnippet.java`
- `src/main/java/file/ZipFilesSnippet.java`
- `src/main/java/io/InputStreamToStringSnippet.java`
- `src/main/java/io/ReadFileSnippet.java`
- `src/main/java/math/EloRatingSnippet.java`
- `src/main/java/math/EvenOdd.java`
- `src/main/java/math/FactorialSnippet.java`
- `src/main/java/math/FibonacciSnippet.java`
- `src/main/java/math/GreatestCommonDivisorSnippet.java`
- `src/main/java/math/HaversineFormulaSnippet.java`
- `src/main/java/math/LeastCommonMultipleSnippet.java`
- `src/main/java/math/LuhnSnippet.java`
- `src/main/java/math/NaturalNumberBinaryConversionSnippet.java`
- `src/main/java/math/PerformLotterySnippet.java`
- `src/main/java/math/PrimeNumberSnippet.java`
- `src/main/java/math/SquareRoot.java`
- `src/main/java/media/CaptureScreenSnippet.java`
- `src/main/java/network/HttpGetSnippet.java`
- `src/main/java/network/HttpPostSnippet.java`
- `src/main/java/string/AnagramSnippet.java`
- `src/main/java/string/CommonLettersSnippet.java`
- `src/main/java/string/CompareVersionSnippet.java`
- `src/main/java/string/DuplicateCharacterSnippet.java`
- `src/main/java/string/FormatBytesSnippet.java`
- `src/main/java/string/KmpSubstringSearchSnippet.java`
- `src/main/java/string/LevenshteinDistanceSnippet.java`
- `src/main/java/string/LindenmayerSystemSnippet.java`
- `src/main/java/string/MaxCharacterCountSnippet.java`
- `src/main/java/string/PalindromCheckSnippet.java`
- `src/main/java/string/ReverseStringSnippet.java`
- `src/main/java/string/StringToDateSnippet.java`
- `src/main/java/system/GetEnvOrDefaultSnippet.java`
- `src/main/java/thread/ThreadPool.java`
- `src/main/java/thread/ThreadSnippet.java`

### java:S2143 — 日期时间建议改用 java.time 新 API （2 处 / 30 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/date/AddDaysToDateSnippet.java: | Use the "java.time" API for date and time. | 15min |
| src/main/java/string/StringToDateSnippet.java: | Use the "java.time" API for date and time. | 15min |

### java:S8786 — 正则表达式存在灾难性回溯，长字符串会卡住 （1 处 / 20 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/string/CompareVersionSnippet.java:60 | Simplify this regular expression to reduce its runtime, as it has super-linear performance due to backtracking. | 20min |

### java:S6204 — 用 Stream.toList() 代替 collect(Collectors.toList()) （4 处 / 20 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/cls/GetAllFieldNamesSnippet.java:52 | Replace this usage of 'Stream.collect(Collectors.toList())' with 'Stream.toList()' and ensure that the list is unmodified. | 5min |
| src/main/java/cls/GetAllMethodsSnippet.java:46 | Replace this usage of 'Stream.collect(Collectors.toList())' with 'Stream.toList()' and ensure that the list is unmodified. | 5min |
| src/main/java/cls/GetAllPublicFieldNamesSnippet.java:46 | Replace this usage of 'Stream.collect(Collectors.toList())' with 'Stream.toList()' and ensure that the list is unmodified. | 5min |
| src/main/java/io/ReadFileSnippet.java:47 | Replace this usage of 'Stream.collect(Collectors.toList())' with 'Stream.toList()' and ensure that the list is unmodified. | 5min |

### java:S127 — for 循环的计数变量不要在循环体里被修改 （2 处 / 20 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/string/PalindromCheckSnippet.java:42 | Refactor the code in order to not assign to this loop counter from within the loop body. | 10min |
| src/main/java/string/PalindromCheckSnippet.java:45 | Refactor the code in order to not assign to this loop counter from within the loop body. | 10min |

### java:S112 — 不要抛通用的 Exception，改用更具体的异常类型 （1 处 / 20 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/network/HttpGetSnippet.java:44 | Replace generic exceptions with specific library exceptions or a custom exception. | 20min |

### java:S9391 — 用 Stream 改写 filter/map/collect 类型的循环 （3 处 / 15 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/array/ArrayModeSnippet.java:56 | Use a stream instead of this loop. | 5min |
| src/main/java/string/CommonLettersSnippet.java:44 | Use a stream instead of this loop. | 5min |
| src/main/java/string/DuplicateCharacterSnippet.java:45 | Use a stream instead of this loop. | 5min |

### java:S2093 — 用 try-with-resources 自动关闭资源 （1 处 / 15 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/file/ZipDirectorySnippetTest.java:50 | Change this "try" to a try-with-resources. | 15min |

### java:S3415 — assertEquals 参数顺序应为（期望值, 实际值） （7 处 / 14 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/array/ArrayConcatSnippetTest.java:43 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/array/ArrayConcatSnippetTest.java:45 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/array/MultiArrayConcatenationSnippetTest.java:43 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/array/MultiArrayConcatenationSnippetTest.java:49 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/file/ZipDirectorySnippetTest.java:65 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/file/ZipDirectorySnippetTest.java:66 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |
| src/test/java/thread/ThreadSnippetTest.java:55 | Swap these 2 arguments so they are in the correct order: expected value, actual value. | 2min |

### java:S1068 — 删掉没用到的私有字段 （2 处 / 10 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/cls/GetAllFieldNamesSnippetTest.java:44 | Remove this unused "superFieldTwo" private field. | 5min |
| src/test/java/cls/GetAllFieldNamesSnippetTest.java:49 | Remove this unused "fieldTwo" private field. | 5min |

### java:S1319 — 变量声明用接口类型（如 Map）而不是具体实现（如 HashMap） （1 处 / 10 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/network/HttpPostSnippet.java:51 | The type of "arguments" should be an interface such as "Map" rather than the implementation "HashMap". | 10min |

### java:S1481 — 删掉没用到的局部变量 （2 处 / 10 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/algorithm/BinarySearchIn2dArraySnippetTest.java:42 | Remove this unused "assertions" local variable. | 5min |
| src/test/java/algorithm/LinearSearchIn2dArraySnippetTest.java:42 | Remove this unused "assertions" local variable. | 5min |

### java:S5786 — JUnit5 测试方法不需要 public 修饰符 （4 处 / 8 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/algorithm/LuhnModnSnippetTest.java:40 | Remove redundant visibility modifiers from the methods of this test class. | 2min |
| src/test/java/string/CompareVersionSnippetTest.java:34 | Remove redundant visibility modifiers from the methods of this test class. | 2min |
| src/test/java/string/LindenmayerSystemSnippetTest.java:38 | Remove redundant visibility modifiers from the methods of this test class. | 2min |
| src/test/java/thread/ThreadPoolTest.java:37 | Remove redundant visibility modifiers from the methods of this test class. | 2min |

### java:S2140 — 生成随机整数不要用 nextDouble() 换算，直接用 nextLong()/nextInt() （1 处 / 5 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/math/RandomNumber.java:59 | Use "nextLong()" instead. | 5min |

### java:S1125 — 去掉多余的布尔字面量 （1 处 / 5 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/algorithm/SieveOfEratosthenesSnippet.java:44 | Remove the unnecessary boolean literal. | 5min |

### java:S1488 — 变量声明后立刻被 return，直接 return 表达式 （2 处 / 4 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/math/EloRatingSnippet.java:50 | Immediately return this expression instead of assigning it to the temporary variable "newRating". | 2min |
| src/main/java/math/LuhnSnippet.java:62 | Immediately return this expression instead of assigning it to the temporary variable "checksumDigit". | 2min |

### java:S1128 — 删掉没用到的 import （3 处 / 3 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/date/AddDaysToDateSnippet.java:28 | Remove this unused import 'java.time.ZoneId'. | 1min |
| src/test/java/io/InputStreamToStringSnippetTest.java:30 | Remove this unused import 'java.io.File'. | 1min |
| src/test/java/math/RandomNumberTest.java:31 | Remove this unused import 'org.junit.jupiter.api.Test'. | 1min |

### java:S7158 — 判断字符串为空用 isEmpty() 而不是 length()==0 （1 处 / 2 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/main/java/string/KmpSubstringSearchSnippet.java:41 | Use "isEmpty()" to check whether a "String" is empty or not. | 2min |

### java:S5785 — 用 assertEquals/assertNotEquals 代替 assertTrue(equals) （1 处 / 2 分钟）

| 文件 File:Line | Sonar 说明 | 工时 |
|---|---|---|
| src/test/java/algorithm/VerhoeffSnippetTest.java:67 | Use assertEquals instead. | 2min |

## 5. 规则速查表 / Rule Reference

| 规则 Rule | 名称 Name | 类型 Type | 严重度 Severity | 通俗解释（中文） |
|---|---|---|---|---|
| java:S1068 | Unused private fields should be removed | CODE_SMELL | MAJOR | 删掉没用到的私有字段 |
| java:S1118 | Utility classes should not have public constructors | CODE_SMELL | MAJOR | 工具类不应有公开构造函数：加一个私有构造函数，防止被 new |
| java:S112 | Generic exceptions should never be thrown | CODE_SMELL | MAJOR | 不要抛通用的 Exception，改用更具体的异常类型 |
| java:S1125 | Boolean literals should not be redundant | CODE_SMELL | MINOR | 去掉多余的布尔字面量 |
| java:S1128 | Unnecessary imports should be removed | CODE_SMELL | MINOR | 删掉没用到的 import |
| java:S127 | for loop stop conditions should be invariant | CODE_SMELL | MAJOR | for 循环的计数变量不要在循环体里被修改 |
| java:S1319 | Declarations should use Java collection interfaces | CODE_SMELL | MINOR | 变量声明用接口类型（如 Map）而不是具体实现（如 HashMap） |
| java:S1481 | Unused local variables should be removed | CODE_SMELL | MINOR | 删掉没用到的局部变量 |
| java:S1488 | Local variables should not be declared and then immediately returned | CODE_SMELL | MINOR | 变量声明后立刻被 return，直接 return 表达式 |
| java:S2093 | Try-with-resources should be used | CODE_SMELL | CRITICAL | 用 try-with-resources 自动关闭资源 |
| java:S2095 | Resources should be closed | BUG | BLOCKER | 资源用完要关闭（资源泄漏，Bug） |
| java:S2140 | Random floating point methods should not be used for integers | CODE_SMELL | MINOR | 生成随机整数不要用 nextDouble() 换算，直接用 nextLong()/nextInt() |
| java:S2143 | java.time classes should be used for dates and times | CODE_SMELL | INFO | 日期时间建议改用 java.time 新 API |
| java:S3415 | Assertion arguments should be passed in the correct order | CODE_SMELL | MAJOR | assertEquals 参数顺序应为（期望值, 实际值） |
| java:S5785 | assertTrue/assertFalse should be simplified | CODE_SMELL | MAJOR | 用 assertEquals/assertNotEquals 代替 assertTrue(equals) |
| java:S5786 | JUnit5 test methods should have default package visibility | CODE_SMELL | INFO | JUnit5 测试方法不需要 public 修饰符 |
| java:S5998 | Regular expressions should not overflow the stack | BUG | MAJOR | 正则表达式不要写成会栈溢出的形式（长输入崩溃，Bug） |
| java:S6204 | Stream.toList() should be used instead of collectors | CODE_SMELL | MAJOR | 用 Stream.toList() 代替 collect(Collectors.toList()) |
| java:S7158 | String.isEmpty() should be used to test for emptiness | CODE_SMELL | MINOR | 判断字符串为空用 isEmpty() 而不是 length()==0 |
| java:S8786 | Regular expressions should not cause non-linear backtracking | CODE_SMELL | MAJOR | 正则表达式存在灾难性回溯，长字符串会卡住 |
| java:S9342 | Archive entries should not be empty | BUG | CRITICAL | 压缩包中不要写入空的条目内容（Bug） |
| java:S9391 | Loops should use Stream API when performing filter, map, or collect operations | CODE_SMELL | MAJOR | 用 Stream 改写 filter/map/collect 类型的循环 |

## 6. 本地 Java 测试与覆盖率基线 / Local Test & Coverage Baseline

- 测试用例 / Tests: **238** 个，失败 **1** 个，错误 0 个，跳过 0 个
- 失败用例 / Failing test: `system.GetEnvOrDefaultSnippetTest.testPresentEnvironmentVariable`（Windows 上环境变量名大小写不一致导致，详见改动记录文档）
- JaCoCo INSTRUCTION: 4668/5102 (91.49%)
- JaCoCo BRANCH: 355/406 (87.44%)
- JaCoCo LINE: 636/747 (85.14%)
- JaCoCo COMPLEXITY: 275/400 (68.75%)
- JaCoCo METHOD: 120/197 (60.91%)
- JaCoCo CLASS: 77/77 (100%)

### 逐类行覆盖率 / Per-class line coverage

| 类 Class | 已覆盖 Covered | 未覆盖 Missed | 行覆盖率 % |
|---|---|---|---|
| array.AllEqualSnippet | 1 | 1 | 50 |
| array.ArrayMeanSnippet | 1 | 1 | 50 |
| array.ArraySumSnippet | 1 | 1 | 50 |
| array.FindMaxSnippet | 1 | 1 | 50 |
| array.FindMinSnippet | 1 | 1 | 50 |
| cls.SafeCastSnippet | 1 | 1 | 50 |
| encoding.Base64DecodeSnippet | 1 | 1 | 50 |
| encoding.Base64EncodeSnippet | 1 | 1 | 50 |
| file.ListDirectoriesSnippet | 1 | 1 | 50 |
| file.ListFilesInDirectorySnippet | 1 | 1 | 50 |
| file.ReadLinesSnippet | 1 | 1 | 50 |
| string.ReverseStringSnippet | 1 | 1 | 50 |
| system.GetEnvOrDefaultSnippet | 1 | 1 | 50 |
| thread.ThreadPool | 1 | 1 | 50 |
| thread.ThreadSnippet | 1 | 1 | 50 |
| math.FibonacciSnippet | 9 | 8 | 52.9 |
| io.InputStreamToStringSnippet | 2 | 1 | 66.7 |
| io.ReadFileSnippet | 2 | 1 | 66.7 |
| string.StringToDateSnippet | 2 | 1 | 66.7 |
| algorithm.BinarySearchIn2dArraySnippet | 28 | 10 | 73.7 |
| array.ArrayConcatSnippet | 3 | 1 | 75 |
| array.ArrayMedianSnippet | 3 | 1 | 75 |
| cls.CreatingObjectSnippet | 3 | 1 | 75 |
| cls.GetAllMethodsSnippet | 3 | 1 | 75 |
| cls.GetAllPublicFieldNamesSnippet | 3 | 1 | 75 |
| date.AddDaysToDateSnippet | 6 | 2 | 75 |
| math.EvenOdd | 3 | 1 | 75 |
| math.GreatestCommonDivisorSnippet | 3 | 1 | 75 |
| math.LeastCommonMultipleSnippet | 6 | 2 | 75 |
| algorithm.LinearSearchSnippet | 4 | 1 | 80 |
| file.ZipDirectorySnippet | 21 | 5 | 80.8 |
| string.FormatBytesSnippet | 13 | 3 | 81.2 |
| math.PrimeNumberSnippet | 9 | 2 | 81.8 |
| algorithm.DammSnippet | 20 | 4 | 83.3 |
| algorithm.LinearSearchIn2dArraySnippet | 5 | 1 | 83.3 |
| math.DiceThrow | 5 | 1 | 83.3 |
| math.PerformLotterySnippet | 5 | 1 | 83.3 |
| network.HttpGetSnippet | 5 | 1 | 83.3 |
| string.DuplicateCharacterSnippet | 5 | 1 | 83.3 |
| array.ArrayModeSnippet | 11 | 2 | 84.6 |
| date.DateDifferenceSnippet | 6 | 1 | 85.7 |
| math.EloRatingSnippet | 6 | 1 | 85.7 |
| media.CaptureScreenSnippet | 6 | 1 | 85.7 |
| string.CommonLettersSnippet | 6 | 1 | 85.7 |
| math.LuhnSnippet | 13 | 2 | 86.7 |
| algorithm.LuhnModnSnippet | 21 | 3 | 87.5 |
| array.ArrayModeInPlaceSnippet | 15 | 2 | 88.2 |
| algorithm.BinarySearchSnippet | 8 | 1 | 88.9 |
| algorithm.BubbleSortSnippet | 8 | 1 | 88.9 |
| algorithm.InsertionSortSnippet | 8 | 1 | 88.9 |
| algorithm.SieveOfEratosthenesSnippet | 8 | 1 | 88.9 |
| file.ListAllFilesSnippet | 8 | 1 | 88.9 |
| math.FactorialSnippet | 8 | 1 | 88.9 |
| string.MaxCharacterCountSnippet | 8 | 1 | 88.9 |
| string.PalindromCheckSnippet | 8 | 1 | 88.9 |
| array.MultiArrayConcatenationSnippet | 9 | 1 | 90 |
| math.RandomNumber | 19 | 2 | 90.5 |
| algorithm.SelectionSortSnippet | 10 | 1 | 90.9 |
| cls.GetAllFieldNamesSnippet | 10 | 1 | 90.9 |
| file.ZipFileSnippet | 10 | 1 | 90.9 |
| string.AnagramSnippet | 10 | 1 | 90.9 |
| string.LevenshteinDistanceSnippet | 10 | 1 | 90.9 |
| string.LindenmayerSystemSnippet | 10 | 1 | 90.9 |
| file.ZipFilesSnippet | 11 | 1 | 91.7 |
| string.CompareVersionSnippet | 11 | 1 | 91.7 |
| algorithm.CycleSortSnippet | 12 | 1 | 92.3 |
| network.HttpPostSnippet | 12 | 1 | 92.3 |
| array.ReverseArraySnippet | 13 | 1 | 92.9 |
| math.NaturalNumberBinaryConversionSnippet | 14 | 1 | 93.3 |
| string.KmpSubstringSearchSnippet | 29 | 2 | 93.5 |
| algorithm.CountingSortSnippet | 15 | 1 | 93.8 |
| algorithm.VerhoeffSnippet | 15 | 1 | 93.8 |
| math.HaversineFormulaSnippet | 15 | 1 | 93.8 |
| math.SquareRoot | 18 | 1 | 94.7 |
| algorithm.QuickSortSnippet | 20 | 1 | 95.2 |
| algorithm.MergeSortSnippet | 26 | 1 | 96.3 |
| math.DiceThrow$DiceSides | 6 | 0 | 100 |
## 7. 如何复现 / How to Reproduce

```powershell
cd C:\tmp\30s-project
$env:GRADLE_USER_HOME='C:\tmp\gradle-home'
$env:SONAR_TOKEN='<你的 token>'
.\gradlew.bat build --no-daemon --console=plain   # 本地构建 + 测试 + 覆盖率
.\gradlew.bat sonarqube -x test --no-daemon --console=plain   # 上传 SonarCloud 分析
```

