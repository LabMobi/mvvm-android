<?xml version="1.0"?>
<recipe>

    <instantiate from="src/app_package/Contract.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Contract.kt" />
    <instantiate from="src/app_package/MvpActivity.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Activity.kt" />
    <instantiate from="src/app_package/Presenter.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Presenter.kt" />
    <instantiate from="src/app_package/Model.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Model.kt" />
    <instantiate from="src/app_package/Fragment.kt.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${className}Fragment.kt" />
    <instantiate from="res/layout/fragment.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/fragment_${classToResource(className)}.xml" />

    <open file="${srcOut}/${className}Presenter.java"/>
</recipe>
