package aspectj.weaving.plugin

class AspectJExtension {

  //判断是否编译
  def isCompile = true
  //判断是否启用
  def enabled = true

  def getIsCompile() {
    return isCompile
  }

  def setIsCompile(isCompile) {
    this.isCompile = isCompile
  }

  def setEnabled(boolean enabled) {
    this.enabled = enabled
  }

  def getEnabled() {
    return enabled;
  }
}
