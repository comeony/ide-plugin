# MindSpore Dev Toolkit 快速入门指南

MindSpore Dev Toolkit作为Pycharm插件工具，为用户提供一键安装conda，创建conda环境，并使用conda创建MindSpore项目等功能。本文旨在帮助用户快速了解使用本产品。

## 一、创建MindSpore项目

### 技术背景

本功能的实现基于[conda](https://conda.io)。Conda是一个包管理和环境管理系统，是MindSpore推荐的安装方式之一。

### 使用步骤

1. 选择File -> New Project。

   ![img](./images/clip_image002.jpg)

2. 选择MindSpore。

   ![img](./images/clip_image004.jpg)

3. Miniconda下载安装。***已经安装过conda的可以跳过此步骤。***
   * 点击 Install Miniconda Automatically按钮。

      ![img](./images/clip_image006.jpg)

   * 选择下载安装文件夹。**建议不修改路径，使用默认路径安装conda。**

      ![img](./images/clip_image008.jpg)

   * 点击Install按钮，等待下载安装。

      ![img](./images/clip_image010.jpg)

      ![img](./images/clip_image012.jpg)

   * Miniconda下载安装完成。

      ![img](./images/clip_image014.jpg)

   * 根据提示重新启动PyCharm或者稍后自行重新启动PyCharm。

      ![img](./images/clip_image015.jpg)

4. 如果Conda executable没有自动填充，选择已安装的conda的路径。

   ![img](./images/clip_image016.jpg)

5. 创建或选择已有的conda环境。
   * 创建新的conda环境。 **建议不修改路径，使用默认路径创建conda环境。由于PyCharm限制，Linux系统下暂时无法选择默认目录以外的地址。**

      ![img](./images/clip_image018.jpg)

   * 选择PyCharm中已有的conda环境。

      ![img](./images/clip_image019.jpg)

6. 选择硬件环境和MindSpore项目最佳实践模板。
   * 选择硬件环境。

      ![img](./images/clip_image020.jpg)

   * 选择最佳实践模板。最佳实践模版是MindSpore提供一些样例项目，以供新用户熟悉MindSpore。最佳实践模版可以直接运行。

      ![img](./images/clip_image021.jpg)

7. 点击Create按钮新建项目，等待MindSpore下载安装成功。
   * 点击Create按钮创建MindSpore新项目。

      ![img](./images/clip_image022.jpg)

   * 正在创建创建conda环境。

      ![img](./images/clip_image023.jpg)

   * 正在通过conda配置MindSpore。

      ![img](./images/clip_image024.jpg)

8. 创建MindSpore项目完成。

      ![img](./images/clip_image025.jpg)

9. 验证MindSpore项目是否创建成功。
   * 点击下方Terminal，输入 python -c "import mindspore;mindspore.run_check()" ，查看输出。  如下图，显示了版本号等，表示MindSpore环境可用。

      ![img](./images/clip_image026.jpg)

   * 如果选择了最佳实践模版，可以通过运行最佳实践，测试MindSpore环境。

      ![img](./images/clip_image027.jpg)

      ![img](./images/clip_image028.jpg)

      ![img](./images/clip_image029.jpg)

## 二、算子互搜

### 使用步骤

1. 双击shift弹出全局搜索页面。

      ![img](./images/clip_image060.jpg)

2. 选择MindSpore。

      ![img](./images/clip_image062.jpg)

3. 输入要搜索的PyTorch或TensorFlow的算子，获取与MindSpore算子的对应关系列表。

      ![img](./images/clip_image064.jpg)

      ![img](./images/clip_image066.jpg)

4. 点击列表中的条目，可以在右边侧边栏浏览对应条目的官网文档。

      ![img](./images/clip_image068.jpg)

## 三、代码补全

### 使用步骤

1. 打开Python文件编写代码。

      ![img](./images/clip_image088.jpg)

2. 编码时，补全会自动生效。有MindSpore图标的条目为MindSpore Dev Toolkit智能补全提供的代码。

      ![img](./images/clip_image090.jpg)

      ![img](./images/clip_image092.jpg)