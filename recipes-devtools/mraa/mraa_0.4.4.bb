SUMMARY = ""
HOMEPAGE = ""
PR = "r0"
LICENSE = "intel"
LIC_FILES_CHKSUM = "file://COPYING;md5=e8db6501ed294e65418a933925d12058"

DEPENDS += "swig"

SRC_URI = "git://github.com/intel-iot-devkit/mraa.git;protocol=https;tag=v${PV}"

do_configure_append () {
	sed -e 's/CMAKE_SKIP_INSTALL_RPATH:BOOL=NO/CMAKE_SKIP_INSTALL_RPATH:BOOL=YES/' \
	-i CMakeCache.txt
	sed -e 's/CMAKE_SKIP_RPATH:BOOL=NO/CMAKE_SKIP_RPATH:BOOL=YES/' \
	-i CMakeCache.txt
	sed -e '3a\  "version" : "${PV}",' -i src/javascript/package.json
}

S = "${WORKDIR}/git"

inherit pkgconfig cmake

FILES_${PN} += " \
	${libdir}/python2.7/site-packages \
	${libdir}/node_modules \
	${libdir}/libmraa.so \
	${libdir}/pkgconfig \
	${includedir}/mraa.h \
	${includedir}/mraa.hpp \
	${includedir}/mraa \
"

FILES_${PN}-dbg += "${libdir}/python2.7/site-packages/.debug"
