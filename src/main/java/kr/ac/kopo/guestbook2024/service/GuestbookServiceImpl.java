package kr.ac.kopo.guestbook2024.service;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.dto.PageResultDTO;
import kr.ac.kopo.guestbook2024.entity.Guestbook;
import kr.ac.kopo.guestbook2024.repository.GuestbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Log4j2
public class GuestbookServiceImpl implements GuestbookService {

    private final GuestbookRepository repository; // final이 꼭 들어가야 함.
    @Override
    public Long register(GuestbookDTO dto) {
        Guestbook entity = dtoToEntity(dto);
        repository.save(entity);

        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn);
    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);

        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void modify(GuestbookDTO dto) {
        Optional<Guestbook> result = repository.findById(dto.getGno());
        if(result.isPresent()) {
            Guestbook entity = result.get();

            entity.changeTitle(dto.getTitle());
            entity.changeContent(dto.getContent());

            repository.save(entity); // 글의 제목과 내용 update문 실행
        }
    }

    @Override
    public void remove(Long gno) {
        repository.deleteById(gno);
    }
}
