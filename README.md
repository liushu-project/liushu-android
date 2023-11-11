# 六書輸入法安卓版

六書輸入法的安卓實現。

## 構建

### 使用Android Studio

1. 首先下載[詞庫](https://github.com/liushu-project/sunman/releases/download/v0.1.0/sunman.trie)到`app/src/main/assets/sunman/`
2. 克隆核心倉庫到`app/src/main/rust/liushu`
3. 使用uniffi生成Kotlin代碼：
   ```bash
   cd app/src/main/rust/liushu
   cargo run -p uniffi-bindgen --release -- generate ./liushu-ffi/src/lib.udl --language kotlin
   mv liushu-ffi/src/com/elliot00/liushu/uniffi/ liushu-android/app/src/main/java/com/elliot00/liushu/
   ```

