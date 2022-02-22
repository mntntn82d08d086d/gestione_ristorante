package org.labsis.gestione_ristorante.service.admin;

/*
@Service
@Transactional
@RequiredArgsConstructor
*/
public class AuthoritiesServiceImpl implements AuthoritiesService/*, UserDetailsService */{

/*
    @Autowired
    private final AuthoritiesRepository repository;
*/

/*    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<List<Authorities>> optionalList = repository.findAuthoritiesByAccount_Username(username);
        String usr = "";
        String psw = "";
        Collection<SimpleGrantedAuthority> list = new ArrayList<>();
        if (!optionalList.isEmpty()) {
            List<Authorities> authorities = optionalList.get();
            usr = authorities.get(0).getAccount().getUsername();
            psw = authorities.get(0).getAccount().getPassword();
            for (Authorities auth : authorities) {
                OldRole role = auth.getOldRole();
                list.add(new SimpleGrantedAuthority(role.getOldRole()));
            }
        }
        return new User(usr, psw, list);
    }*/
}
