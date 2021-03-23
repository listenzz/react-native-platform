require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "RNPlatform"
  s.version      = package["version"]
  s.summary      = package["description"]
 
  s.homepage     = "https://github.com/listenzz/react-native-platform"
  s.license      = "MIT"
  s.authors      = { "listen" => "listenzz@163.com" }
  s.platforms    = { :ios => "10.0", :tvos => "10.0" }
  s.source       = { :git => "https://github.com/listenzz/react-native-platform.git", :tag => "#{s.version}" }

  s.source_files = "ios/Platform/**/*.{h,m,swift}"
  s.dependency "React"
end