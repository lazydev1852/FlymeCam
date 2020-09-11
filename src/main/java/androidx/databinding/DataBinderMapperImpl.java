package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
    DataBinderMapperImpl() {
        addMapper((DataBinderMapper) new com.meizu.media.camera.DataBinderMapperImpl());
    }
}
