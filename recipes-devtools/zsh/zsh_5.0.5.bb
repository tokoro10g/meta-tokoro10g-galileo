DESCRIPTION = "The Zsh shell"
SECTION = "base/shell"
PRIORITY = "optional"
DEPENDS = "ncurses libpcre"
PR = "r0"
LICENSE = "zsh"
LIC_FILES_CHKSUM = "file://LICENCE;md5=b7bc853894664be455a922db9805288e"

SRC_URI = "http://www.zsh.org/pub/zsh-${PV}.tar.bz2 \
"

inherit autotools

do_configure() { 
   oe_runconf
}

EXTRA_OECONF = "--with-term-lib="ncurses" --with-tcsetpgrp"
PARALLEL_MAKE = ""

#Kill symlink
do_install_append () {
    mv ${D}${bindir}/zsh-${PV} ${D}${bindir}/zsh
}

SRC_URI[md5sum] = "6156dc2f19b0a067bdbc0fb7f81e2017"
SRC_URI[sha256sum] = "6624d2fb6c8fa4e044d2b009f86ed1617fe8583c83acfceba7ec82826cfa8eaf"
